package allocation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
/**
 * A "Closed" TimeInterval. Not used now.
 * */
public class TimePeriod {
	Date begin;
	Date end;
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	@Column(name="\"end\"") 
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}
