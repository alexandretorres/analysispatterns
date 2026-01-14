package allocation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Unit {
	int idUnit;
	String name;
	@Id
	public int getIdUnit() {
		return idUnit;
	}
	public void setIdUnit(int idUnit) {
		this.idUnit = idUnit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
