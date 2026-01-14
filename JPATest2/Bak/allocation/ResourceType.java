package allocation;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ResourceType {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name+ "";
	}
}
