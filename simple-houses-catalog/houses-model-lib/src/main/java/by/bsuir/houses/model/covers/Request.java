package by.bsuir.houses.model.covers;

public interface Request extends Cover{

	enum Action {
		CREATEHOUSE, EDITHOUSE, FINDHOUSE, SORTHOUSE, ALLHOUSES
	}
	
	Action getCurrentAction();
}
