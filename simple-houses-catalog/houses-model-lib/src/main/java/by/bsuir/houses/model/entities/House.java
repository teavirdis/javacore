package by.bsuir.houses.model.entities;

public class House extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7880708290400523127L;
	
	private String address;
	private int size;
	
	
	public House(String address, int size) {
		super();
		this.address = address;
		this.size = size;
	}
	
	public House() {
		
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + size;
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
		House other = (House) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "House [address=" + address + ", size=" + size + "]";
	}
	

}
