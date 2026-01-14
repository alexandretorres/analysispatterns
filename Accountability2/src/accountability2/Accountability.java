package accountability2;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Accountability {
	@Id @GeneratedValue private int idAccountability;
	@ManyToOne(optional=false)
	@JoinColumn(name="COMMISSIONER_ID")
	private Party commissioner;
	@ManyToOne(optional=false)
	@JoinColumn(name="RESPONSIBLE_ID")
	private Party responsible;
	@ManyToOne(optional=false)
	private AccountabilityType accountabilityType;
	@Embedded private TimePeriod timePeriod;
	
	public int getIdAccountability() {
		return idAccountability;
	}
	public void setIdAccountability(int idAccountability) {
		this.idAccountability = idAccountability;
	}
	public Party getCommissioner() {
		return commissioner;
	}
	public void setCommissioner(Party commissioner) {
		this.commissioner = commissioner;
	}
	public Party getResponsible() {
		return responsible;
	}
	public void setResponsible(Party responsible) {
		this.responsible = responsible;
	}
	public AccountabilityType getAccountabilityType() {
		return accountabilityType;
	}
	public void setAccountabilityType(AccountabilityType accountabilityType) {
		this.accountabilityType = accountabilityType;
	}
	public TimePeriod getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(TimePeriod timePeriod) {
		this.timePeriod = timePeriod;
	}
	
	
}
