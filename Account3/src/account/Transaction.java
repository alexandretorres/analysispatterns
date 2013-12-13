package account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Transaction {
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_transaction")
	private Date date;
	@OneToMany(mappedBy = "transaction")
	private List<Entry> entries;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRANSACTION")
	private long id;

	public Transaction() {

	}

	public void transfer(DetailAccount origin, DetailAccount dest, Quantity qty) {
		newEntry(origin, qty.negate());
		newEntry(dest, qty);
	}

	public Entry newEntry(DetailAccount acct, Quantity qty) {
		Entry e = new Entry(acct, qty);
		getEntries().add(e);
		e.setTransaction(this);
		acct.getEntries().add(e);
		return e;
	}

	public Date getDate() {
		return date;
	}

	public List<Entry> getEntries() {
		if (entries == null)
			entries = new ArrayList<Entry>();
		return entries;
	}

	public long getId() {
		return id;
	}

	public void setId(long transId) {
		this.id = transId;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Transaction) {
			return ((Transaction) o).id == id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) id;
	}
}
