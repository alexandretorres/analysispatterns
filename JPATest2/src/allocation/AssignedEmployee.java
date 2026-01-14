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

public class AssignedEmployee extends TemporalAllocation {
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
	public String toString() {
		return super.toString()+" employee "+(getEmployee()==null?"null":employee.toString());
	}
}
