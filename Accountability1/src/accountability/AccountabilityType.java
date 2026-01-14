package accountability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AccountabilityType {
	@Id @GeneratedValue private int accountabilityTypeId;
	@Column(nullable=false,length=50) private String description;
	@ManyToOne
	private Rule rule;
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
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	

}
