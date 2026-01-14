package allocation;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STOCK")
public class Location {
	int idLocation;
	Set<Holding> holdings;
	@Id
	@Column(name="ID_STOCK")
	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}
	@OneToMany(mappedBy="location")
	public Set<Holding> getHoldings() {
		return holdings;
	}

	public void setHoldings(Set<Holding> holdings) {
		this.holdings = holdings;
	}
	
	
	
}
