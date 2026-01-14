package allocation;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@AttributeOverride(name="start", column=@Column(name="ACQUISITION"))
@Table(name="EQUIPMENT")
public class Equipment extends Asset {
	int idEquipment;
	Set<EquipmentType> types;
	@Id
	@Column(name="ID_EQUIPMENT")
	public int getIdEquipment() {
		return idEquipment;
	}

	public void setIdEquipment(int idEquipment) {
		this.idEquipment = idEquipment;
	}
	@ManyToMany
	@JoinTable(name="EQUIP_EQUIP_TYPES")
	public Set<EquipmentType> getTypes() {
		return types;
	}
	public void setTypes(Set<EquipmentType> types) {
		this.types=types;
	}
	
}
