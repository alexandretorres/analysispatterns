package allocation;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.NamedQuery;

import org.apache.commons.collections15.collection.CompositeCollection;
import org.apache.commons.collections15.set.CompositeSet;



@Entity
@Table(name="TASK")

public class Action {
	private String name;
	private int idAction;
	
	// specific resource relationships
	private Set<SupplyRequirement> supplyRequirements;
	private Set<ConsumableAllocation> requiredConsumable;
	private Set<EquipmentRequirement> equimentRequirements;
	private Set<ScheduledEquipment> scheduledEquipments;
	private Set<WorkRequirement> workRequirements;
	private Set<AssignedEmployee> assignedEmployees;
	
	
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
	@Transient
	private CompositeSet<ResourceAllocation> resources = null;
	@Transient
	public Set<ResourceAllocation> getResources() {
		return resources;
	}
	

	@OneToMany(mappedBy="action")
	protected Set<SupplyRequirement> getSupplyRequirements() {
		return supplyRequirements;
	}
	protected void setSupplyRequirements(Set<SupplyRequirement> supplyRequirements) {
		addToResourceSet(this.supplyRequirements, supplyRequirements);
		this.supplyRequirements = supplyRequirements;
	}
	@OneToMany(mappedBy="action")
	protected Set<ConsumableAllocation> getRequiredConsumable() {
		return requiredConsumable;
	}
	protected void setRequiredConsumable(Set<ConsumableAllocation> requiredConsumable) {
		addToResourceSet(this.requiredConsumable, requiredConsumable);
		this.requiredConsumable = requiredConsumable;
	}
	@OneToMany(mappedBy="action")
	protected Set<EquipmentRequirement> getEquimentRequirements() {
		return equimentRequirements;
	}
	protected void setEquimentRequirements(
			Set<EquipmentRequirement> equimentRequirements) {
		addToResourceSet(this.equimentRequirements, equimentRequirements);
		this.equimentRequirements = equimentRequirements;
	}
	@OneToMany(mappedBy="action")
	protected Set<ScheduledEquipment> getScheduledEquipments() {
		return scheduledEquipments;
	}
	protected void setScheduledEquipments(
			Set<ScheduledEquipment> scheduledEquipments) {
		addToResourceSet(this.scheduledEquipments, scheduledEquipments);
		this.scheduledEquipments = scheduledEquipments;
	}
	@OneToMany(mappedBy="action")
	protected Set<WorkRequirement> getWorkRequirements() {
		return workRequirements;
	}
	protected void setWorkRequirements(Set<WorkRequirement> workRequirements) {
		addToResourceSet(this.workRequirements, workRequirements);
		this.workRequirements = workRequirements;
	}
	@OneToMany(mappedBy="action")
	protected Set<AssignedEmployee> getAssignedEmployees() {
		return assignedEmployees;
	}
	protected void setAssignedEmployees(Set<AssignedEmployee> assignedEmployees) {
		addToResourceSet(this.assignedEmployees, assignedEmployees);
		this.assignedEmployees = assignedEmployees;
	}
	
	private void addToResourceSet(Set<? extends ResourceAllocation> oldSet,Set<? extends ResourceAllocation> set) {		
		if (resources==null) {
			resources = new CompositeSet<ResourceAllocation>();
			resources.setMutator(new ResourceMutator<ResourceAllocation>());
		} 
		if (oldSet==set)
			return;
		if (oldSet!=null && resources.getCollections().contains(oldSet))
			resources.removeComposited(oldSet);
		//	
		resources.addComposited(set);
	}
	private class ResourceMutator<E> implements CompositeSet.SetMutator<E> {
		@Override
		public void resolveCollision(CompositeSet<E> comp, Set<E> existing,
				Set<E> added, Collection<E> intersects) {
			if (!intersects.isEmpty()) {
				throw new RuntimeException("All sets must be disjoint - or use non SET collection");
			}			
		}
		@Override
		public boolean add(CompositeCollection<? extends E> composite ,
				Collection<? extends E>[] collections, Object obj) {
			
			if (obj instanceof SupplyRequirement) {
				return getSupplyRequirements().add((SupplyRequirement) obj);
			} else if (obj instanceof ConsumableAllocation) {
				return getRequiredConsumable().add((ConsumableAllocation)obj);
			} else if (obj instanceof ScheduledEquipment) {
				return getScheduledEquipments().add((ScheduledEquipment)obj);
			} else if (obj instanceof EquipmentRequirement) {
				return getEquimentRequirements().add((EquipmentRequirement)obj);
			} else if (obj instanceof AssignedEmployee) {
				return getAssignedEmployees().add((AssignedEmployee)obj);
			} else if (obj instanceof WorkRequirement) {
				return getWorkRequirements().add((WorkRequirement)obj);
			} else {
				throw new IllegalArgumentException();
			}
			/*
			boolean ret=false;
			for (int i=0;i<collections.length;i++) {
				Type p = collections[i].getClass().getGenericSuperclass();
				if (obj.getClass().isAssignableFrom(p.getClass()));
				//if (coolections[i].)
			}
			return ret;*/
		}

		@Override
		public boolean addAll(CompositeCollection<? extends E> arg0,
				Collection<? extends E>[] arg1, Collection<? extends E> arg2) {
			throw new UnsupportedOperationException("add All not supported");
		}

		

		@Override
		public boolean remove(CompositeCollection<? extends E> arg0,
				Collection<? extends E>[] arg1, Object arg2) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("add All not supported");
		}
		
	}
	
}
