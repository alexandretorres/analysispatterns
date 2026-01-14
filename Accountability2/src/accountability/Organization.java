package accountability;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  @DiscriminatorValue(value="O")
public class Organization extends Party {
	
}
