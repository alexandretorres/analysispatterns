package allocation;

import java.util.Date;
import java.util.Set;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
@MappedSuperclass
public abstract class Asset {
	Date start;

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Transient
	public abstract Set<? extends AssetType> getTypes();
	
}
