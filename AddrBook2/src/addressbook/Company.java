package addressbook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import javax.persistence.*;

@Entity @DiscriminatorValue(value="C") 
public class Company extends Party{	
	@Column(unique=true,length=14) private String cnpj;	
	protected Company(){
		
	}
	
	public Company(String name, String cnpj){
		setName(name);
		setCnpj(cnpj);
	}
	
	
	private void setCnpj(String cnpj){
		this.cnpj = cnpj;
	}	
	
	public String getCnpj(){
		return cnpj;
	}
	
}
