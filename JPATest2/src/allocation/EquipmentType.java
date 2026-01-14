package allocation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPMENT_TYPE")
public class EquipmentType extends AssetType{
	int eqtypeId;
	@Id
	@Column(name="ID_EQTYPE")
	public int getEqtypeId() {
		return eqtypeId;
	}

	public void setEqtypeId(int eqtypeId) {
		this.eqtypeId = eqtypeId;
	}
	
}
