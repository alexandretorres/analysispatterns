package allocation;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Column;;


@Entity
@Table(name="SUPPLY_REQUIREMENTS")
@AttributeOverride(name="quantity.ammount", column=@Column(name="QUANTITY"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="QTY_UNIT"))
@IdClass(SupplyRequirementPK.class)
public class SupplyRequirement extends GeneralAllocation{	 
	//Action action;	
	ConsumableType supply;
	
	
	@Id
	@JoinColumn(name="ID_TASK",insertable=false,updatable=false)
	@ManyToOne
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	
	@Id
	@ManyToOne
	@JoinColumn(name="ID_SUPPLY")
	public ConsumableType getResourceType() {
		return supply;
	}
	public void setResourceType(ResourceType supply) {
		this.supply = (ConsumableType) supply;
	}
/*		
	@EmbeddedId
	public SupplyRequirementPK getId() {
		return id;
	}
	public void setId(SupplyRequirementPK id) {
		this.id = id;
	}
	*/
	/*
	@MapsId("idAction")
	@JoinColumn(name="ID_TASK",insertable=false,updatable=false)
	@ManyToOne
	public Action getTask() {
		return action;
	}
	public void setTask(Action action) {
		this.action = action;
	}*/
/*
	@MapsId("idAction")
	@JoinColumn(name="ID_TASK")	
	@ManyToOne
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}*/
	/*
	@MapsId("idComsumableType")
	@ManyToOne
	@JoinColumn(name="ID_SUPPLY")
	public ConsumableType getResourceType() {
		return supply;
	}
	public void setResourceType(ResourceType supply) {
		this.supply = (ConsumableType) supply;
	}
	*/

	public String toString() {
		return super.toString()+",res"+(supply!=null ? supply.toString() :  "null")+",actionId["+(action!=null ? action.getIdAction() :  "null")+"]";
	}
	
	
}
