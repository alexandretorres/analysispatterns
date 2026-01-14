package addressbook;

import javax.persistence.*;

@Embeddable
public class Address {
	private String address;
	@Column(length=30) private String city;
	@Column(length=2) private String state;

	protected Address(){
		
	}
	
	public Address(String address, String city, String state) {
		setAddress(address);
		setCity(city);
		setState(state);
	}

	private void setAddress(String address) {
		this.address = address;
	}

	private void setCity(String city) {
		this.city = city;
	}

	private void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

}
