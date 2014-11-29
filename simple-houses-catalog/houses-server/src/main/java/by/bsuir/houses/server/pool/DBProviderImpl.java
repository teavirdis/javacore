package by.bsuir.houses.server.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProviderImpl extends DBProvider {

	private String driver;
	private String user;
	private String pass;
	private String base;
	private String host;
	private String port;
	private String connectionString;

	@Override
	public WrappedConnection getConnection() throws SQLException {
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(connectionString);
		return new WrappedConnection(connection);
	}

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
