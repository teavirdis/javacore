package by.bsuir.houses.model.covers;

public interface Response extends Cover{
	
	enum Status {
		SUCCESS, ERROR
	}
	
	Status getStatus();

}
