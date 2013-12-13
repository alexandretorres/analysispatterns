package account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("D")
public class DetailAccount extends Account {
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Entry> entries;

	protected DetailAccount() {

	}

	public DetailAccount(Unit unit) {
		setUnit(unit);
		entries = new ArrayList<Entry>();
		balance();
	}

	@Override
	public List<Entry> getEntries() {
		if (entries == null)
			entries = new ArrayList<Entry>();
		return entries;
	}

	@Override
	public Entry newEntry(Quantity amount) throws InvalidUnitForEntryException {
		Unit unit = amount.getUnit();

		if (getEntries() != null && !getEntries().isEmpty()) {
			unit = getEntries().get(0).getQuantity().getUnit();

			if (!(unit.equals(amount.getUnit())))
				throw (new InvalidUnitForEntryException(
						"A nova entrada deve ter o mesmo tipo "
								+ "de unidade das entradas anteriores."));
		}
		Entry entry = new Entry(this, amount);
		getEntries().add(entry);
		return entry;

	}
	/** 
	 * Transfers quantity from withdrawl and deposit in this account 
	 */
	public Transaction newDeposit(DetailAccount withdrawl, Quantity qty) {
		Transaction trans = new Transaction();
		trans.transfer(withdrawl, this, qty);
		return trans;
	}
}
