package by.bsuir.houses.server.main;

import java.sql.SQLException;

import by.bsuir.houses.server.pool.ConnectionPool;
import by.bsuir.houses.server.pool.DBProviderImpl;
import by.bsuir.houses.server.pool.DBService;
import by.bsuir.houses.server.threaded.ThreadedServer;

public class ServerStart {

	public static void main(String[] args) throws SQLException{
		//
		String driver = "com.mysql.jdbc.Driver";
		String connectionString = "jdbc:mysql://localhost/bsuir_houses?"
				+ "user=root&password=root";
		int timeout = 6000;
		int maxsize = 8;
		//
		DBProviderImpl dbprovider = new DBProviderImpl();
		dbprovider.setDriver(driver);
		dbprovider.setConnectionString(connectionString);
		DBService service = new DBService();
		service.setDbProvider(dbprovider);
		service.setMaxsize(maxsize);
		service.setTimeout(timeout);
		ConnectionPool connectionPool = ConnectionPool.newInstance();
		connectionPool.setDbProvider(service);
		connectionPool.fillPool();
		//
		ThreadedServer.start();
	}
}
