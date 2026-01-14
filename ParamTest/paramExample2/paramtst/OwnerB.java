package paramtst;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class OwnerB extends Owner<PropertyB>{
	//@Id
	//int id;
	@OneToMany(mappedBy="owner")
	Set<PropertyB> properties= new HashSet<PropertyB>();

	public Set<PropertyB> getProperties() {
		return properties;
	}

	public void setProperties(Set<PropertyB> properties) {
		this.properties = properties;
	}
	
}
