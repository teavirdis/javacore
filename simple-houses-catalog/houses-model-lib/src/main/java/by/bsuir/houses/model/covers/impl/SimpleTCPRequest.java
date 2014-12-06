package by.bsuir.houses.model.covers.impl;

import java.util.List;

import by.bsuir.houses.model.covers.Request;
import by.bsuir.houses.model.entities.House;
import by.bsuir.houses.model.entities.Person;

public class SimpleTCPRequest extends AbstractCover implements Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5073511181083026839L;

	public SimpleTCPRequest(List<House> houses, List<Person> persons,
			House house, Person person) {
		super(houses, persons, house, person);
	}

	private Action action;

	public Action getCurrentAction() {
		return action;
	}

}
