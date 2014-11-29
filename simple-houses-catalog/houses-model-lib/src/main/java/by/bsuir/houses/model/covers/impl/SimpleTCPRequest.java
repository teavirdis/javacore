package by.bsuir.houses.model.covers.impl;

import by.bsuir.houses.model.covers.Request;

public class SimpleTCPRequest extends AbstractCover implements Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5073511181083026839L;
	
	private Action action;

	public Action getCurrentAction() {
		return action;
	}

}
