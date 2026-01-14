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
public class Property<E extends Owner> {
	//@Id
	//int id;
	@ManyToOne
	E owner;

	public E getOwner() {
		return owner;
	}

	public void setOwner(E owner) {
		this.owner = owner;
	}
}
