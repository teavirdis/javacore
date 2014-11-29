package by.bsuir.houses.server.pool;

public class ConnectionReaper extends Thread {

	private ConnectionPool pool;

	ConnectionReaper(ConnectionPool pool) {
		this.pool = pool;
	}

	public void run() {
		while (true) {
			try {
				sleep(pool.getDelay());
			} catch (InterruptedException e) {
				pool.reapConnections();
			}
		}
	}

}
