package by.bsuir.houses.model.covers;

import java.io.Serializable;

public interface Request extends Serializable{

	enum Action {
		CREATEHOUSE, EDITHOUSE, FINDHOUSE, SORTHOUSE, ALLHOUSES
	}
	
	Action getCurrentAction();
}
