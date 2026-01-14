package allocation;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AttributeOverride(name="quantity.ammount", column=@Column(name="REQUESTED_TIME"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="TIME_UNIT"))
public abstract class TemporalAllocation extends SpecificAllocation{
	Date scheduledTo;
	@Column(name="START",nullable=true)
	public Date getScheduledTo() {
		return scheduledTo;
	}

	public void setScheduledTo(Date scheduledTo) {
		this.scheduledTo = scheduledTo;
	}
}
