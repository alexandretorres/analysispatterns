package allocation;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@AttributeOverride(name="quantity.ammount", column=@Column(name="REQUESTED_TIME"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="TIME_UNIT"))
public class TemporalAllocation extends SpecificAllocation{
		
	private TimePeriod timePeriod;
	private Asset asset;
	
	@Embedded
	public TimePeriod getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(TimePeriod timePeriod) {
		this.timePeriod = timePeriod;
	}
	@Transient
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
	
}
