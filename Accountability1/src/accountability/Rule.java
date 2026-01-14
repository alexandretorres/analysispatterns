package accountability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rule {
	@Id @GeneratedValue private int ruleId;
	@Column(nullable=false,length=50) private String description;
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
