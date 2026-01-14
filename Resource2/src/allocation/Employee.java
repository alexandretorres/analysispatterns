package allocation;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@AttributeOverride(name="start", column=@Column(name="HIRE_DATE"))
@Table(name="EMPLOYEE")
public class Employee extends Asset{
	int idEmployee;
	Set<Post> posts;
	String name;
	@Id
	@Column(name="ID_EMPLOYEE")
	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	@ManyToMany
	@JoinTable(name="EMPLOYEE_POSTS")
	public Set<Post> getTypes() {
		return posts;
	}

	public void setTypes(Set<Post> posts) {
		this.posts = posts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
