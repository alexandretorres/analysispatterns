package accountability;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  @DiscriminatorValue(value="R")
public class Region extends Organization {

}
