package accountability;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PARTY_TYPE")
public abstract class Party {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)private int idParty;
	@Column(nullable = false, length=50) private String name;
	@OneToMany(mappedBy="commissioner") private Set<Accountability> commissioners;
	@OneToMany(mappedBy="responsible") private Set<Accountability> responsibles;
	
	

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

	public Set<Accountability> getCommissioners() {
		return commissioners;
	}

	public void setCommissioners(Set<Accountability> commissioners) {
		this.commissioners = commissioners;
	}

	public Set<Accountability> getResponsibles() {
		return responsibles;
	}

	public void setResponsibles(Set<Accountability> responsibles) {
		this.responsibles = responsibles;
	}

	
	
	
	
}
