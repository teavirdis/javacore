package by.bsuir.houses.model.covers;

import java.io.Serializable;

public interface Response extends Serializable{
	
	enum Status {
		SUCCESS, ERROR
	}
	
	Status getStatus();

}
