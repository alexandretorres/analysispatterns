package addressbook;
import java.text.Collator;
import java.util.Locale;

class CompanyComparator implements java.util.Comparator {
	public int compare(Object o1, Object o2) {
		Collator myCollator = Collator.getInstance(Locale.US);
		if(o1==null && o2==null)
			return 0;
		else{
			if(o1==null)
				return 1;
			else{
				if(o2==null)
					return -1;
				else return myCollator.compare(((Company) o1).getName(), ((Company) o2).getName());
			}
		}
	}
}


