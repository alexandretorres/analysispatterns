package allocation;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Quantity {
	Unit unit;
	double ammount;
	Quantity() {
		
	}
	public Quantity(double ammount, Unit unit) {
		this.ammount = ammount;
		this.unit=unit;
	}
	@ManyToOne
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String toString() {
		return getAmmount()+" "+(unit!=null ? unit.getName() :  "null")+ " ";
	}
}
