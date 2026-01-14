package paramtst;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PropertyA extends Property {
	@Id
	int id;
	/*
	@ManyToOne
	OwnerA owner;

	public OwnerA getOwner() {
		return owner;
	}

	public void setOwner(OwnerA owner) {
		this.owner = owner;
	}*/
	
}
