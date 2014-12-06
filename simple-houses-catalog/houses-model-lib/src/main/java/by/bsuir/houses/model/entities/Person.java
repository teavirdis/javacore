package by.bsuir.houses.model.entities;

import java.io.Serializable;

public class Person extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1459114946662481470L;
	
	private String name;
	private int houseId;
	
	public Person(String name, int houseId) {
		super();
		this.name = name;
		this.houseId = houseId;
	}
	
	public String getName() {
		return name;
	}
	//public void setName(String name) {
	//	this.name = name;
	//}
	public int getHouseId() {
		return houseId;
	}
	//public void setHouseId(int houseId) {
	//	this.houseId = houseId;
	//}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + houseId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (houseId != other.houseId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", houseId=" + houseId + "]";
	}
	
	

}
