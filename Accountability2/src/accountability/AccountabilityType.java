package accountability;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class AccountabilityType {
	@Id @GeneratedValue private int accountabilityTypeId;
	@Column(nullable=false,length=50) private String description;
	
	@ManyToMany
	@JoinTable(name="ACCTYPE_COMMISSIONERS")
	private Set<PartyType> commissioners;
	@ManyToMany
	@JoinTable(name="ACCTYPE_RESPONSIBLES")
	private Set<PartyType> responsibles;
	
	
	public int getAccountabilityTypeId() {
		return accountabilityTypeId;
	}
	public void setAccountabilityTypeId(int accountabilityTypeId) {
		this.accountabilityTypeId = accountabilityTypeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<PartyType> getCommissioners() {
		if (commissioners ==null)
			commissioners = new HashSet<PartyType>();
		return commissioners;
	}
	public void setCommissioners(Set<PartyType> commissioners) {
		this.commissioners = commissioners;
	}
	public Set<PartyType> getResponsibles() {
		if (responsibles ==null)
			responsibles = new HashSet<PartyType>();
		return responsibles;
	}
	public void setResponsibles(Set<PartyType> responsibles) {
		this.responsibles = responsibles;
	}
	

}
