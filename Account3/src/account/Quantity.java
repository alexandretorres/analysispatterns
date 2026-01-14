package account;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.*;

@Embeddable
public class Quantity {
	@Column(precision=20,scale=2)
	private BigDecimal amount;
	@ManyToOne
	private Unit unit;

	protected Quantity() {

	}

	public Quantity(BigDecimal amount, Unit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	public Quantity(double amount, Unit unit) {
		this.amount = new BigDecimal( amount);
		this.unit = unit;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Unit getUnit() {
		return unit;
	}

	@Override
	public boolean equals(Object obj) {
		if (getAmount() == ((Quantity) obj).getAmount()
				&& getUnit().equals(((Quantity) obj).getUnit()))
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		Object[] hashArray = new Object[2];
		hashArray[0] = getAmount();
		hashArray[1] = getUnit();
		return Arrays.hashCode(hashArray);
	}

	public Quantity negate() {
		return new Quantity(amount.negate(), unit);
	}

	public String toString() {
		return amount + "," + unit.getName();
	}
}
