package addressbook;
import java.io.Serializable;
import java.lang.*;
import java.util.Arrays;

import javax.persistence.*;

@Entity @Table(name="TELEPHONES") @IdClass(TelephonePK.class) public class Telephone{
	@Id @Column(length=5)private int area;
	@Id @Column(length=8)private int number;
	@ManyToOne(optional=false) private Party party;
	//methods
	protected Telephone(){
		
	}
	
	public Telephone(int area, int number){
		setArea(area);
		setNumber(number);
	}
	
	@Override
	public boolean equals(Object obj){
		if(this.getArea()==((Telephone)obj).getArea()
		&& this.getNumber()==((Telephone)obj).getNumber())
			return true;
		else return false;
	}
	
	@Override	
	public int hashCode() {
		Object[] hashArray = new Object[2];
		hashArray[0] = getArea();
		hashArray[1] = getNumber();
		return Arrays.hashCode(hashArray);
	}
	
	private void setArea(int area){
		this.area=area;
	}

	private void setNumber(int number){
		this.number=number;
	}
	
	
	
	public int getArea(){
		return area;
	}
	
	public int getNumber(){
		return number;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
	
}
class TelephonePK implements Serializable{
	private int area, number;
	
	public TelephonePK(int area, int number){
		this.area = area;
		this.number = number;
	}

	public TelephonePK() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + area;
		result = prime * result + number;
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
		TelephonePK other = (TelephonePK) obj;
		if (area != other.area)
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	
	
}
