package allocation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="SUPPLY")
public class ConsumableType extends ResourceType{
	int idComsumableType;		

	@Id
	@Column(name="ID_SUPPLY")
	public int getIdComsumableType() {
		return idComsumableType;
	}

	public void setIdComsumableType(int idComsumableType) {
		this.idComsumableType = idComsumableType;
	}
	public String toString() {
		return super.toString()+"[id="+idComsumableType+"]";
	}
}
