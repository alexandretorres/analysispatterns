package allocation;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="WORK_REQUIREMENTS")
@AttributeOverride(name="quantity.ammount", column=@Column(name="REQUESTED_TIME"))
@AssociationOverride(name="quantity.unit",joinColumns=@JoinColumn(name="TIME_UNIT"))
public class WorkRequirement extends GeneralAllocation {	
	int requirementId;		
	
	//Action action;	
	Post post;
		
	@Id
	@Column(name="id_requirement",precision=8)
	public int getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}
	/*
	@ManyToOne
	public Post getPost() {
		return post;
	}
	public void setPost(Post equipment) {
		this.post = post;
	}	
	*/
	/*
	@ManyToOne
	@JoinColumn(name="ID_TASK")
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	*/
	
	@ManyToOne
	@JoinColumn(name="ID_POST")
	public Post getResourceType() {
		return post;
	}
	public void setResourceType(ResourceType post) {
		this.post = (Post) post;
	}	
	public String toString() {
		return super.toString()+" post "+(getResourceType()==null?"null":post.toString());
	}
}