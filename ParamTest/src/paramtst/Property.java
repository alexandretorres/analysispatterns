package paramtst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
//@MappedSuperclass
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Property<E extends Owner> {
	@GeneratedValue
	@Id
	int id;
	@ManyToOne
	Owner owner;

	public E getOwner() {
		return (E)owner;
	}

	public void setOwner(E owner) {
		this.owner = owner;
	}
}
