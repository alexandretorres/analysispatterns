package allocation;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SupplyRequirementPK implements Serializable{
	int idAction;
	int resourceType;
	public int getAction() {
		return idAction;
	}
	public void setAction(int idAction) {
		this.idAction = idAction;
	}
	public int getResourceType() {
		return resourceType;
	}
	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}
	
}
