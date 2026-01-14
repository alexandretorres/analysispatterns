package accountability2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PARTY_TYPE")
public abstract class Party {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)private int idParty;
	@Column(nullable = false, length=50) private String name;
	@OneToMany(mappedBy="commissioner") private Set<Accountability> commissionerOf;
	@OneToMany(mappedBy="responsible") private Set<Accountability> responsibleFor;	
	@ManyToMany
	private Set<PartyType> types;

	public int getIdParty() {
		return idParty;
	}

	public void setIdParty(int idParty) {
		this.idParty = idParty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Accountability> getCommissionerOf() {
		if (commissionerOf==null)
			commissionerOf = new HashSet<Accountability>();
		return commissionerOf;
	}

	public void setCommissionerOf(Set<Accountability> commissionerOf) {
		this.commissionerOf = commissionerOf;
	}

	public Set<Accountability> getResponsibleFor() {
		if (responsibleFor==null)
			responsibleFor = new HashSet<Accountability>();
		return responsibleFor;
	}

	public void setResponsibleFor(Set<Accountability> responsibleFor) {
		this.responsibleFor = responsibleFor;
	}

	public Set<PartyType> getTypes() {
		if (types==null)
			types = new HashSet<PartyType>();
		return types;
	}

	public void setTypes(Set<PartyType> types) {
		this.types = types;
	}

	
	
	
	
}
