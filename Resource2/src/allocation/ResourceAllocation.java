package allocation;

import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ResourceAllocation {
	Action action;
	Quantity quantity;
	@Embedded
	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}
	@ManyToOne
	@JoinColumn(name="ID_TASK")
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public String toString() {
		return super.toString()+",qtd"+(quantity!=null ? quantity.toString() :  "null");
	}
}
