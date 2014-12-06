package by.bsuir.houses.client.builder;

import java.util.List;

import by.bsuir.houses.model.builders.RequestBuilder;
import by.bsuir.houses.model.covers.Request;
import by.bsuir.houses.model.covers.impl.SimpleTCPRequest;
import by.bsuir.houses.model.entities.House;
import by.bsuir.houses.model.entities.Person;

public class RequestBuilderImpl implements RequestBuilder {

	private Request.Action action;

	public List<House> buildListOfHouses() {
		// TODO Auto-generated method stub
		return null;
	}

	public House buildHouse() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> buildListOfPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	public Person buildPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	public Request.Action getAction() {
		return action;
	}

	public void setAction(Request.Action action) {
		this.action = action;
	}

	public Request buildRequest() {

		return new SimpleTCPRequest(null, null, null, null, action);
	}

	public Request getRequest() {

		return buildRequest();
	}

}
