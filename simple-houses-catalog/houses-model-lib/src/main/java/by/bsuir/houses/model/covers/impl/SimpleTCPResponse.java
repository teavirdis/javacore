package by.bsuir.houses.model.covers.impl;

import java.util.List;

import by.bsuir.houses.model.covers.Response;
import by.bsuir.houses.model.entities.House;
import by.bsuir.houses.model.entities.Person;

public class SimpleTCPResponse extends AbstractCover implements Response{



	/**
	 * 
	 */
	private static final long serialVersionUID = 5204837889289669815L;

	private Status status;
	
	public Status getStatus() {
		return status;
	}
	
	public SimpleTCPResponse(List<House> houses, List<Person> persons,
			House house, Person person, Status status) {
		super(houses, persons, house, person);
		this.status = status;
	}

}
