package paramtst;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class OwnerA extends Owner<PropertyA>{
	//@Id
	//int id;
	/*
	@OneToMany(mappedBy="owner")
	Set<PropertyA> properties= new HashSet<PropertyA>();

	public Set<PropertyA> getProperties() {
		return properties;
	}

	public void setProperties(Set<PropertyA> properties) {
		this.properties = properties;
	}
	*/
}
