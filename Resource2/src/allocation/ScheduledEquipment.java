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

public class ScheduledEquipment extends TemporalAllocation {
	int idSchedule;
	//Equipment equipment;
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
		return (Equipment) getAsset(); //redefines
	}

	public void setEquipment(Equipment equipment) {
		setAsset(equipment);
		//this.equipment = equipment;
	}
	

}
