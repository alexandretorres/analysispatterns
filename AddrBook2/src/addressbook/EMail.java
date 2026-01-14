package addressbook;

import javax.persistence.*;

@Embeddable
public class EMail {
	@Column(length=50)private String email;
	
	protected EMail(){
		
	}
	
	public EMail(String email){
		setEmail(email);
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public boolean validate(){
		if(getEmail()!=null)
			return getEmail().matches("[A-Za-z]+([_]?[.]?[A-Za-z]+)*[@]{1}[a-z]*([.]{1}[a-z]+)+");
		else return false;
	}
}
