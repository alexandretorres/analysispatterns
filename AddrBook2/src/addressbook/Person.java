package addressbook;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

/**
 * Representa uma pessoa física no sistema. Duas pessoas são iguais quando tem o mesmo CPF. 
 * @author Mateus
 *
 */	
@Entity @DiscriminatorValue(value="P")
public class Person extends Party{	
	@Column(unique=true,length=11) private String cpf;
	
	/**
	 * Cria uma pessoa
	 * @param name o nome não deve ser nulo
	 * @param cpf o cpf não deve ser nulo
	 */
	
	protected Person(){
		
	}
	
	public Person(String name, String cpf){
		setName(name);
		setCpf(cpf);
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(this.getCpf()==((Person) obj).getCpf())
			return true;
		else return false;
	}
	
	@Override
	public int hashCode() {
		return getCpf().hashCode();	
	}

	
	
	
}
