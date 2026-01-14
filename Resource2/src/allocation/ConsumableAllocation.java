package allocation;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SUPPLY_REQUIRED")
@AttributeOverride(name="quantity.ammount", column=@Column(name="QUANTITY"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="QTY_UNIT"))
@IdClass(ConsumablePK.class)
public class ConsumableAllocation extends SpecificAllocation {
	Holding holding;		
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
	@JoinColumn(name="ID_SUPPLYACCT")
	@ManyToOne
	public Holding getHolding() {
		return holding;
	}
	public void setHolding(Holding holding) {
		this.holding = holding;
	}
	public String toString() {
		return super.toString()+",res "+(holding!=null ? holding.toString() :  "null")+",actionId["+(action!=null ? action.getIdAction() :  "null")+"]";
	}
	

}
