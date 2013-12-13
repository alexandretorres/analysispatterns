package account;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 1)
@SecondaryTable(name = "Act_Brief")
public abstract class Account implements Comparable<Account> {
	@SequenceGenerator(name = "ACCT_SEQUENCE",sequenceName="ACCT_SEQUENCE")
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ACCT_SEQUENCE")
	private int number;
	@Embedded
	@AttributeOverride(name = "amount", column = @Column(name = "value", table = "Act_Brief"))
	@AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "UNIT", table = "Act_Brief"))
	private Quantity lastBalance = new Quantity();
	@Column(name = "dt_calc", table = "Act_Brief")
	@Temporal(TemporalType.DATE)
	private Date dt_balance;
	
	@ManyToMany(mappedBy = "components")
	List<SummaryAccount> summary;

	protected Account() {

	}

	
	public int getNumber() {
		return number;
	}

	public Unit getUnit() {
		return lastBalance.getUnit();
	}

	public abstract List<Entry> getEntries();

	protected void setUnit(Unit unit) {
		if (lastBalance != null)
			this.lastBalance = new Quantity(lastBalance.getAmount(), unit);
		else
			this.lastBalance = new Quantity(0, unit);
	}

	protected void setNumber(int number) {
		this.number = number;
	}

	public Quantity balance() {
		double sum = 0;
		Unit unit = null;
		List<Entry> entries = getEntries();
		for (Entry entry :entries) {
			sum += entry.getQuantity().getAmount();
			unit = entry.getQuantity().getUnit();
		}
		this.lastBalance = new Quantity(sum, unit);
		this.dt_balance = new Date();
		return this.lastBalance;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account && getNumber() == ((Account) obj).getNumber())
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return getNumber();
	}

	public abstract Entry newEntry(Quantity amount)
			throws InvalidUnitForEntryException;

	@Override
	public int compareTo(Account o) {
		if (getNumber() < o.getNumber())
			return -1;
		else if (getNumber() > o.getNumber())
			return 1;
		else
			return 0;
	}


	public Quantity getLastBalance() {
		return lastBalance;
	}


	public Date getDt_balance() {
		return dt_balance;
	}

}
