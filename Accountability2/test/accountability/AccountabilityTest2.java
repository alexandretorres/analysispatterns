package accountability;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import accountability2.Accountability;
import accountability2.AccountabilityType;
import accountability2.Organization;
import accountability2.PartyType;
import accountability2.Person;
import accountability2.TimePeriod;


public class AccountabilityTest2 {

	public void persist(EntityManager em,Object... objs) {
		for (Object ob:objs) {
			em.persist(ob);
		}
	}
	@Test
	public void test() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Accountability2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			
			PartyType opUnit = new PartyType();
			opUnit.setDescription("Operation Unit");
			persist(em,opUnit);
			
			PartyType region = new PartyType();
			region.setDescription("Region");
			persist(em,region);
			
			PartyType employee = new PartyType();
			employee.setDescription("Employee");
			persist(em,employee);
			
			AccountabilityType at = new AccountabilityType();
			at.setDescription("act1");
			at.getResponsibles().add(opUnit);
			at.getResponsibles().add(employee);
			at.getCommissioners().add(region);
			persist(em,at);			
			
			Person person = new Person();
			person.setName("Fulano");
			person.getTypes().add(employee);
			persist(em,person);
			
			Organization oper = new Organization();
			oper.setName("bla");
			oper.getTypes().add(opUnit);
			persist(em,oper);		
			
			Accountability ac = new Accountability();
			ac.setAccountabilityType(at);
			ac.setCommissioner(oper);
			ac.setResponsible(person);
			TimePeriod tp = new TimePeriod();
			tp.setBegin(new Date());
			tp.setEnd(new Date());
			ac.setTimePeriod(tp);
			
			persist(em,ac);
			
			/*
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
			persist(em,person);*/
			//
			//em.flush();
			tx.commit();
			
			
			
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
