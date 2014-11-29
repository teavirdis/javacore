package by.bsuir.houses.server.pool;

public class DBService {

	private DBProvider dbProvider;
	private long timeout;
	private int maxsize;
	
	public DBProvider getDbProvider() {
		return dbProvider;
	}

	public void setDbProvider(DBProvider dbProvider) {
		this.dbProvider = dbProvider;
	}
	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public int getMaxsize() {
		return maxsize;
	}

	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}
}
