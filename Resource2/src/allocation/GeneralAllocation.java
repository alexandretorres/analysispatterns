package allocation;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class GeneralAllocation extends ResourceAllocation {
	/*	
	ResourceType resourceType;
	
	@ManyToOne
	AssetType getAssetType() {
		return (AssetType) resourceType;
	}
	void setAssetType(AssetType asset) {
		resourceType = (AssetType) asset;
	}
	
	
	@Transient
	public ResourceType getResourceType() {
		return resourceType;
	}
	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}
	*/
	@Transient
	abstract public ResourceType getResourceType();
	abstract public void setResourceType(ResourceType res);
}
