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
@Table(name="ASSIGNED_EMPLOYEE")
@AttributeOverride(name="quantity.ammount", column=@Column(name="REQUESTED_TIME"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="TIME_UNIT"))
public class AssignedEmployee extends TemporalResource {
	int idAssignment;	
	Employee employee;
	@Id
	@Column(name="ID_ASSIGNMENT")
	public int getIdAssignment() {
		return idAssignment;
	}

	public void setIdAssignment(int idAssignment) {
		this.idAssignment = idAssignment;
	}
	@ManyToOne
	@JoinColumn(name="ID_EMPLOYEE")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
