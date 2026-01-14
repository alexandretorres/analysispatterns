package accountability2;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PartyType { 
	@Id @GeneratedValue private int idPartyType;
	@Column(nullable = false, length=50) private String description;
	@ManyToMany(mappedBy="commissioners") private Set<AccountabilityType> commissionerOf;
	@ManyToMany(mappedBy="responsibles") private Set<AccountabilityType> responsibleFor;
	public int getIdPartyType() {
		return idPartyType;
	}
	public void setIdPartyType(int idPartyType) {
		this.idPartyType = idPartyType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<AccountabilityType> getCommissionerOf() {
		return commissionerOf;
	}
	public void setCommissionerOf(Set<AccountabilityType> commissionerOf) {
		this.commissionerOf = commissionerOf;
	}
	public Set<AccountabilityType> getResponsibleFor() {
		return responsibleFor;
	}
	public void setResponsibleFor(Set<AccountabilityType> responsibleFor) {
		this.responsibleFor = responsibleFor;
	}
	
	
}
