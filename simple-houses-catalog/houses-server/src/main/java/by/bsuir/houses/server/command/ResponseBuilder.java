package by.bsuir.houses.server.command;

import java.util.List;

import by.bsuir.houses.model.builders.Builder;
import by.bsuir.houses.model.covers.Response;
import by.bsuir.houses.model.covers.Response.Status;
import by.bsuir.houses.model.covers.impl.SimpleTCPResponse;
import by.bsuir.houses.model.entities.House;
import by.bsuir.houses.model.entities.Person;

public class ResponseBuilder implements Builder{
	
	private List<House> houses;
	private Response.Status status;

	public List<House> buildListOfHouses() {
		
		return houses;
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
	
	public void setHousesList(List<House> houses){
		this.houses = houses;
	}
	
	public void setSuccess(){
		status = Status.SUCCESS;
	}
	
	public void setError(){
		status = Status.ERROR;
	}

	public Response buildResponse() {
		
		return new SimpleTCPResponse(houses, null, null, null, status);
	}

}
