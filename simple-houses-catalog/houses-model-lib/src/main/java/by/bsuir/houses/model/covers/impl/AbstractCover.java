package by.bsuir.houses.model.covers.impl;

import by.bsuir.houses.model.entities.*;

import java.util.List;

public abstract class AbstractCover {

	private List<House> houses;
	private List<Person> persons;
	private House house;
	private Person person;

	public AbstractCover(List<House> houses, List<Person> persons, House house,
			Person person) {
		super();
		this.houses = houses;
		this.persons = persons;
		this.house = house;
		this.person = person;
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
