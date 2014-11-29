package by.bsuir.houses.server.command;

import by.bsuir.houses.model.covers.Request;
import by.bsuir.houses.model.covers.Request.Action;

public class CommandFactory {

	public static Command buildCommand(Request request) {
		Action action = request.getCurrentAction();
		Command command = null;
		switch (action) {
		case ALLHOUSES:
			command = new ReadHousesCommand();
			break;
		default:
			command = new ReadHousesCommand();
			break;
		}
		return command;
	}

}
