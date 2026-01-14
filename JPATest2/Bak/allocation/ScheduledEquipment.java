package allocation;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SCHEDULED_EQUIPMENT")
@AttributeOverride(name="quantity.ammount", column=@Column(name="REQUESTED_TIME"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="TIME_UNIT"))

public class ScheduledEquipment extends TemporalResource {
	int idSchedule;

	Equipment equipment;
	@Id
	@Column(name="ID_SCHEDULE")
	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}
	@ManyToOne
	@JoinColumn(name="ID_EQUIPMENT")
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	

}
