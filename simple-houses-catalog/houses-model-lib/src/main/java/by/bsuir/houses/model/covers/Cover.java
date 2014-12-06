package by.bsuir.houses.model.covers;

import java.io.Serializable;
import java.util.List;

import by.bsuir.houses.model.entities.House;
import by.bsuir.houses.model.entities.Person;

public interface Cover extends Serializable{

	public List<House> getHouses();

	public void setHouses(List<House> houses);

	public List<Person> getPersons();

	public void setPersons(List<Person> persons);

	public House getHouse();

	public void setHouse(House house);

	public Person getPerson();

	public void setPerson(Person person);

}
