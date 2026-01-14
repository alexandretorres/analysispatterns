package allocation;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ConsumablePK  implements Serializable{
	int action;
	int holding;
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getHolding() {
		return holding;
	}
	public void setHolding(int holding) {
		this.holding = holding;
	}

}
