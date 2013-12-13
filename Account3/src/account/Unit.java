package account;

import javax.persistence.*;

@Entity
public class Unit implements Comparable<Unit> {
	@Id
	@Column(name = "Unit")
	private String name;

	protected Unit() {

	}

	public Unit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (getName() == ((Unit) obj).getName())
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public int compareTo(Unit unit) {
		return getName().compareTo(unit.getName());
	}
}
