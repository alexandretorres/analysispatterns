package allocation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
public class Action {
	String name;
	int idAction;
	
	
	@Id
	@Column(name="ID_TASK")
	public int getIdAction() {
		return idAction;
	}
	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
