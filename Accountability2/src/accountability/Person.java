package accountability;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Entity @DiscriminatorValue(value="P")
public class Person extends Party{	
	
	protected Person(){
		
	}	
	
	
}
