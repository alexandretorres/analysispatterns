package addressbook;

import java.lang.Integer;

/*
 * Dei uma melhorada, apesar que tu não usava. Adotei o tipo genérico
 */
public class TelephoneComparator implements java.util.Comparator<Telephone> {
	public int compare(Telephone tel1, Telephone tel2) {		
		if (tel1 == null || tel2 == null)
			return tel1==tel2 ? 0 : tel1==null ? -1 : +1;
		else
			if (tel1.equals(tel2))  // sempre bom ter consistência com equals, se for o caso.
				return 0;
			else
				return tel1.getNumber() - tel2.getNumber(); 		
		// e a área não entra? que tal aproveitar a comparação natural de strings:
		// return (tel1.getArea()+" "+ tel1.getNumber()).compareTo(tel2.getArea()+" "+tel2.getNumber());
			
		
	}
}
