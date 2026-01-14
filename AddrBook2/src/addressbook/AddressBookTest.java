package addressbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddressBookTest {

	@Test
	public void test() {
		AddressBook aBook = new AddressBook(8, 8);
		try {
			aBook.deleteAllData();
			aBook.addPerson(new Person("Claudio", "1436"));
			aBook.addPerson(new Person("Alice", "1234"));
			aBook.addPerson(new Person("Eduardo", "1638"));
			aBook.addPerson(new Person("Bruna", "1335"));
			aBook.addPerson(new Person("Diego", "1837"));
			aBook.addPerson(new Person("Augusto", "1537"));
			aBook.addPerson(new Person("Ana", "1597"));
			aBook.addPerson(new Person("Mariane", "2539"));
			aBook.addPerson(new Person("Milena", "3539"));
			aBook.addCompany(new Company("Perdigao", "123456"));
			aBook.addCompany(new Company("Oi", "133557"));
			aBook.addCompany(new Company("Tigre", "143658"));
			aBook.addCompany(new Company("Petrobras", "153759"));
			aBook.findPersonByName("Alice").setEmail("alice@gmail.com");
			aBook.findPersonByName("Claudio").setEmail(
					"claudio_silva@hotmail.com");
			aBook.findPersonByName("Eduardo").setEmail(
					"eduardo.xyz@inf.ufrgs.br");
			aBook.findPersonByName("Bruna").setEmail("brunagmail.com");
			aBook.findPersonByName("Diego").setEmail("diego@gmail.com");
			aBook.findPersonByName("Augusto").setEmail("augusto@gmail.com.");
			aBook.findPersonByName("Ana").setEmail("ana..@gmail.com");
			aBook.findPersonByName("Mariane").setEmail("Mariane@gmail.com");
			aBook.findPersonByName("Milena").setEmail("milena@hotmail.com");
			aBook.findPersonByName("Alice").setAddress(new Address("Beach Street", "POA",
					"RS"));
			aBook.findPersonByName("Bruna").setAddress(new Address("Salty Son", "POA",
					"RS"));
			aBook.findPersonByName("Claudio").setAddress(new Address("John Person", "POA",
					"RS"));
			aBook.findPersonByName("Diego").setAddress(new Address("Chief Priest", "POA",
					"RS"));
			aBook.findPersonByName("Eduardo").setAddress(new Address(
					"Patriotic Volunteers", "POA", "RS"));
			/*aBook.findCompanyByName("Perdigao").addTelephone(51, 98765432, aBook.getManager());
			aBook.findCompanyByName("Perdigao").addTelephone(51, 89674422, aBook.getManager());
			aBook.findCompanyByName("Perdigao").addTelephone(51, 97865342, aBook.getManager());
			aBook.findCompanyByName("Tigre").addTelephone(51, 97753331, aBook.getManager());
			aBook.findCompanyByName("Oi").addTelephone(51, 96745230, aBook.getManager());
			aBook.findCompanyByName("Petrobras").addTelephone(51, 95735129, aBook.getManager());
			*/
			aBook.findCompanyByName("Perdigao").setEmail(
					"galinha@perdigao.com.br");
			aBook.findCompanyByName("Tigre").setEmail("canotigre.com");
			aBook.findCompanyByName("Oi").setEmail("hello@gmail.com");
			aBook.findCompanyByName("Petrobras").setEmail("$$$@petroleo.com");
			
			//aBook.findPersonByName("Eduardo").addTelephone(51, 81179754, aBook.getManager());
			aBook.removePerson(aBook.findPersonByName("Diego"));
			assertNull(aBook.findPersonByName("Diego"));
		} finally {
			aBook.close();
		}
	}

}
