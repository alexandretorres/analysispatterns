package addrbook;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import addressbook.Company;
import addressbook.Person;
import addressbook.Telephone;

public class AddrBookTest {
	public void persist(EntityManager em,Object... objs) {
		for (Object ob:objs) {
			em.persist(ob);
		}
	}
	@Test
	public void test() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("AddrBook2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			
			Company cia = new Company("CIA1", "12345678901234");
			Telephone tel = new Telephone(51,55556666);
			cia.getTelephones().add(tel);
			tel.setParty(cia);
			persist(em,cia);
			
			cia = new Company("CIA2", "12345678901266");
			tel = new Telephone(51,55557777);
			cia.getTelephones().add(tel);
			tel.setParty(cia);
			tel = new Telephone(51,55557778);
			cia.getTelephones().add(tel);
			tel.setParty(cia);
			persist(em,cia);
			
			Person person = new Person("Guy","12345678901");
			tel = new Telephone(51,55550000);
			person.getTelephones().add(tel);
			tel.setParty(person);
			persist(em,person);
			//
			//em.flush();
			tx.commit();
			
			//this will fail
			boolean fail = false;
			try {
				tx = em.getTransaction();
				tx.begin();
				cia = new Company("DUP", "12345678901266");
				persist(em,cia);
				tx.commit();
			} catch  (Exception ex) {
				fail=true;				
			}		
			assertTrue("Duplicate company exception:violate unique cnpj",fail);
			
		} catch (Exception ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex); // or display error message
		} finally {
			em.close();
			emf.close();
		}
		
				
		
	}

}
