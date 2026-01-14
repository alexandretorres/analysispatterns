package allocation;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SUPPLY_REQUIRED")
@AttributeOverride(name="quantity.ammount", column=@Column(name="QUANTITY"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="QTY_UNIT"))
public class Consumable extends SpecificAllocation {
	int idSupplyReq;
	Holding holding;
	@Id
	@Column(name="ID_SUPPLYREQ")
	public int getIdSupplyReq() {
		return idSupplyReq;
	}
	public void setIdSupplyReq(int idSupplyReq) {
		this.idSupplyReq = idSupplyReq;
	}
	@ManyToOne
	@JoinColumn(name="ID_SUPPLYACCT")
	public Holding getHolding() {
		return holding;
	}
	public void setHolding(Holding holding) {
		this.holding = holding;
	}
	

}
