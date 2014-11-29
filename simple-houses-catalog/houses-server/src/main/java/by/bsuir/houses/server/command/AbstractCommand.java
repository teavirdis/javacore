package by.bsuir.houses.server.command;

import by.bsuir.houses.server.pool.ConnectionPool;

public abstract class AbstractCommand implements Command{
	
	private ConnectionPool connectionPool;
	
	public ConnectionPool getConnectionPool(){
		return this.connectionPool;
	}
	
	public void setConnectionPool(ConnectionPool connectionPool){
		this.connectionPool = connectionPool;
	}

}
