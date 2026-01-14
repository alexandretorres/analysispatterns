package allocation;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
@Entity
@Table(name="EQUIPMENT_REQUIREMENTS")
@AttributeOverride(name="quantity.ammount", column=@Column(name="REQUESTED_TIME"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="TIME_UNIT"))
public class EquipmentRequirement extends GeneralAllocation {	
	int requirementId;		
	
	//Action action;	
	EquipmentType equipment;
		

	@Id
	@Column(name="ID_EQUIPREQ")
	public int getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}
	/*
	@ManyToOne
	public EquipmentType getEquipment() {
		return equipment;
	}
	public void setEquipment(EquipmentType equipment) {
		this.equipment = equipment;
	}	
	*/
	/*
	@ManyToOne
	@JoinColumn(name="ID_TASK")
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}*/

	@ManyToOne
	@JoinColumn(name="ID_EQTYPE")
	public EquipmentType getResourceType() {
		return equipment;
	}
	public void setResourceType(ResourceType equipment) {
		this.equipment = (EquipmentType) equipment;
	}
	
}
