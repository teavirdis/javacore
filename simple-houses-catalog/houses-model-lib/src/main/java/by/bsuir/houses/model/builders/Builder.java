package by.bsuir.houses.model.builders;

import java.util.List;

import by.bsuir.houses.model.covers.Response;
import by.bsuir.houses.model.entities.House;
import by.bsuir.houses.model.entities.Person;

public interface Builder {
	
	List<House> buildListOfHouses();

	House buildHouse();

	List<Person> buildListOfPersons();

	Person buildPerson();
	
	Response buildResponse();

}
