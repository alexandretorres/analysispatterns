package account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("S")
public class SummaryAccount extends Account {

	@ManyToMany
	@JoinTable(name = "Act_Comps")
	private List<Account> components;

	protected SummaryAccount() {

	}

	public SummaryAccount(List<Account> components) {
		this.components = components;
		balance();
	}

	@Override
	public List<Entry> getEntries() {
		List<Entry> listEntry = new ArrayList<Entry>();
		for (Account acct : components) {
			listEntry.addAll(acct.getEntries());
		}
		return listEntry;
	}

	@Override
	public Entry newEntry(Quantity amount) throws InvalidUnitForEntryException {
		return null;
	}

	public List<Account> getComponents() {
		if (components == null)
			components = new ArrayList<Account>();
		return components;
	}

	public void setComponents(List<Account> components) {
		this.components = components;
	}

}
