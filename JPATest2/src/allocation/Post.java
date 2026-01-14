package allocation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="POST")
public class Post extends AssetType{
	int idPost;
	@Id
	@Column(name="ID_POST")
	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}	

	
	
	
}