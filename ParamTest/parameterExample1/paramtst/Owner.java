package paramtst;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
//@MappedSuperclass
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Owner<E extends Property> {
	@Id
	int id;
	//@OneToMany(mappedBy="owner")
	//Set<E> properties = new HashSet<E>();
	public Set<E> allProperty() {
		return null;
	}
	
	//public Set<E> getProperties() {
	//	return properties;
	//}
}
