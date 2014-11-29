package by.bsuir.houses.server.pool;

import java.sql.SQLException;

public abstract class DBProvider {

	public abstract WrappedConnection getConnection() throws SQLException;
	
}
