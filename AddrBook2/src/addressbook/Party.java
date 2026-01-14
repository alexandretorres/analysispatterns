package addressbook;

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

@Entity  @Table(name="PARTIES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PARTY_TYPE")
public abstract class Party {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)private int idParty;
	@Column(nullable = false, length=50) private String name;
	@OneToMany(mappedBy="party",cascade=CascadeType.ALL) private Set<Telephone> telephones;
	@Embedded private Address address;	
	@Embedded private EMail email;
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
	public Set<Telephone> getTelephones() {
		if(telephones==null)
			telephones = new HashSet<Telephone>(8);
		return telephones;
	}
	public void setTelephones(Set<Telephone> telephones) {
		this.telephones = telephones;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public EMail getEmail() {
		return email;
	}
	public void setEmail(EMail email) {
		this.email = email;
	}	
	public void setEmail(String email) {
		this.email = new EMail(email);
	}	
	
}
