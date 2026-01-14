package allocation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SUPPLY_ACCOUNT")
public class Holding {
	int idHolding;
	ConsumableType consumableType;
	Location location;
	@Id
	@Column(name="ID_SUPPLYACCT")
	public int getIdHolding() {
		return idHolding;
	}
	public void setIdHolding(int idHolding) {
		this.idHolding = idHolding;
	}
	@ManyToOne
	@JoinColumn(name="ID_SUPPLY")
	public ConsumableType getConsumableType() {
		return consumableType;
	}
	public void setConsumableType(ConsumableType consumableType) {
		this.consumableType = consumableType;
	}
	@ManyToOne
	@JoinColumn(name="ID_STOCK")
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	// entries... balance method.... so on...
	public String toString() {
		return (consumableType!=null ? consumableType.toString() :  "null")+" ,holding ["+ idHolding+ "], stockid="+(location!=null ? location.getIdLocation() :  "null")+" ";
	}
}
