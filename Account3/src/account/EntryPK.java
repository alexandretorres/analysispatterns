package account;

import java.io.Serializable;

public class EntryPK implements Serializable {
	private int account;
	private long transaction;

	public EntryPK() {

	}

	public EntryPK(int account, long transaction) {
		this.account = account;
		this.transaction = transaction;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EntryPK) {
			EntryPK pk = (EntryPK) obj;
			return pk.account == account && pk.transaction == transaction;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return account + ((int) transaction);
	}

}
