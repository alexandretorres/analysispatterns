package account;

import javax.persistence.*;

@Entity
@IdClass(EntryPK.class)
public class Entry {
	@Id
	@JoinColumn(name = "ACCT_NUMBER", referencedColumnName = "NUMBER", updatable = false)
	@ManyToOne
	private DetailAccount account;
	@Id
	@JoinColumn(name = "ID_TRANSACTION", referencedColumnName = "ID_TRANSACTION", updatable = false)
	@ManyToOne
	private Transaction transaction;
	@Embedded
	@AssociationOverride(name = "unit", joinColumns = @JoinColumn(name = "UNIT"))
	private Quantity quantity;

	protected Entry() {

	}

	public Entry(DetailAccount account, Quantity quantity) {
		setAccount(account);
		setQuantity(quantity);
	}

	public Account getAccount() {
		return this.account;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public Quantity getQuantity() {
		return this.quantity;
	}

	public void setAccount(DetailAccount account) {
		this.account = account;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Entry) {
			Entry ent = (Entry) obj;
			return (ent.getAccount() == getAccount() && ent.getTransaction() == ent
					.getTransaction());
		}
		return false;
	}

}
