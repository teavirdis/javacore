package by.bsuir.houses.server.pool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import org.apache.log4j.Logger;

public class ConnectionPool {

	private ArrayList<WrappedConnection> connections;
	private DBService dbProvider;
	private ConnectionReaper reaper;
	private Semaphore semaphore;
	private static volatile ConnectionPool instance;
	private final static Logger log = Logger.getLogger(ConnectionPool.class);
	private long delay;

	public static ConnectionPool newInstance() throws SQLException {
		ConnectionPool localInstance = instance;
		if (localInstance == null) {
			synchronized (ConnectionPool.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new ConnectionPool();
				}
			}
		}
		return localInstance;
	}

	public DBService getDbProvider() {
		return dbProvider;
	}

	public void setDbProvider(DBService provider) {
		this.dbProvider = provider;

	}

	public void fillPool() {
		connections = new ArrayList<WrappedConnection>(dbProvider.getMaxsize());
		semaphore = new Semaphore(dbProvider.getMaxsize(), true);
		for (int i = 0; i < dbProvider.getMaxsize(); i++) {

			WrappedConnection conn;
			try {
				conn = dbProvider.getDbProvider().getConnection();
				conn.setInuse(false);
				conn.setId(i);
				connections.add(conn);
				log.info("Connection Pool added " + i + " connection");
			} catch (SQLException e) {
				log.info("Connection Pool couldn't be create because of "
						+ e.getMessage());
			}
		}
		reaper = new ConnectionReaper(this);
		reaper.start();
	}

	public void emptyPool() throws SQLException {
		for (int i = 0; i < dbProvider.getMaxsize(); i++) {

			WrappedConnection con = connections.get(i);
			if (con != null) {
				con.close();
			}

			log.info("Connection Pool added " + i + " connection");
		}
	}

	private ConnectionPool() throws SQLException {

		log.info("ConnectionPool creating");
	}

	public WrappedConnection chekOut() throws InterruptedException,
			SQLException {
		semaphore.acquire();
		return this.getConnection();
	}

	public void chekIn(WrappedConnection conn) {
		if (this.releaseConnection(conn)) {
			semaphore.release();
		}
	}

	private synchronized WrappedConnection getConnection() throws SQLException {
		Iterator<WrappedConnection> iter = connections.iterator();
		while (iter.hasNext()) {
			WrappedConnection conn = iter.next();

			if (!conn.isInuse()) {
				conn.setInuse(true);
				if (!conn.validate()) {
					conn = dbProvider.getDbProvider().getConnection();
				}
				log.info(conn.getId() + " connection was getted");
				return conn;
			}
		}
		return null;
	}

	private synchronized boolean releaseConnection(WrappedConnection conn) {
		int index = connections.indexOf(conn);
		if (index == -1)
			return false;
		conn.setInuse(false);
		log.info(conn.getId() + " connection was returned");
		return true;
	}

	public synchronized void reapConnections() {
		long stale = System.currentTimeMillis() - dbProvider.getTimeout();
		Iterator<WrappedConnection> iter = connections.iterator();
		while (iter.hasNext()) {
			WrappedConnection conn = iter.next();
			if (conn.isInuse() && stale > conn.getTimestamp()
					&& !conn.validate()) {
				releaseConnection(conn);
			}
		}

	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	protected void finalize() {
		for (int i = 0; i < dbProvider.getMaxsize(); i++) {
			try {
				if (connections.get(i) != null) {
					connections.get(i).close();
					log.info("Connection Pool closed " + i + " connection");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
