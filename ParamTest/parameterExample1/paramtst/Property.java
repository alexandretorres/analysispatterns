package paramtst;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Property {
	//@Id
	//int id;
	@ManyToOne
	Owner owner;

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
