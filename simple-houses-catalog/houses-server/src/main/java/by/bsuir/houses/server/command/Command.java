package by.bsuir.houses.server.command;

import by.bsuir.houses.model.covers.Response;
import by.bsuir.houses.server.dao.HouseApplicationSQLException;

public interface Command {
	
	Response execute() throws HouseApplicationSQLException;

}
