package accountability;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  @DiscriminatorValue(value="O")
public class OperatingUnit extends Organization {

}
