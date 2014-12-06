package by.bsuir.houses.server.command;

import java.sql.SQLException;

import by.bsuir.houses.model.covers.Request;
import by.bsuir.houses.model.covers.Response;
import by.bsuir.houses.server.dao.HouseApplicationSQLException;
import by.bsuir.houses.server.dao.HouseDAO;

public class ReadHousesCommand extends AbstractCommand{
	
	private ResponseBuilderImpl responseBuilder = new ResponseBuilderImpl();

	public Response execute(Request request) throws HouseApplicationSQLException {
		HouseDAO dao;
		try {
			dao = new HouseDAO();
			responseBuilder.setHousesList(dao.findAll());
			responseBuilder.setSuccess();
		} catch (InterruptedException e) {
			responseBuilder.setError();
		} catch (SQLException e) {
			responseBuilder.setError();
		}
		
		return responseBuilder.getResponse();
	}

}
