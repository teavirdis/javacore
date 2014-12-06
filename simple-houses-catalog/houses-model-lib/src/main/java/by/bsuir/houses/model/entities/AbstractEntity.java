package by.bsuir.houses.model.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractEntity implements Serializable{

	private int id;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
}
