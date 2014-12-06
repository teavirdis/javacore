package by.bsuir.houses.server.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import by.bsuir.houses.server.pool.ConnectionPool;
import by.bsuir.houses.server.pool.WrappedConnection;

public abstract class AbstractDAO<T> extends BaseDAO<T> {

	private static final Logger log = Logger.getLogger(AbstractDAO.class);

	private WrappedConnection connection;

	public AbstractDAO() throws InterruptedException, SQLException {

		connection = ConnectionPool.newInstance().chekOut();

	}

	public WrappedConnection getConnection() throws SQLException {
		if (connection != null)
			return connection;
		else
			throw new SQLException("No connection");
	}

	public void closeConnection() {

		try {
			ConnectionPool.newInstance().chekIn(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void close(Statement st) {
		if (st != null) {

			try {
				st.close();
			} catch (SQLException e) {
				log.error(e.getMessage());
			}

		}
	}

	public void close(PreparedStatement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				log.error(e.getMessage());
			}

	}

	public void close(CallableStatement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				log.error(e.getMessage());
			}

	}

}
