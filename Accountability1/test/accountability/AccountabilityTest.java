package accountability;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;


public class AccountabilityTest {

	public void persist(EntityManager em,Object... objs) {
		for (Object ob:objs) {
			em.persist(ob);
		}
	}
	@Test
	public void test() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Accountability1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Person person = new Person();
			person.setName("Fulano");
			persist(em,person);
			OperatingUnit oper = new OperatingUnit();
			oper.setName("bla");
			persist(em,oper);
			
			Rule r1 = new Rule();
			r1.setDescription("r1");
			AccountabilityType at = new AccountabilityType();
			at.setDescription("act1");
			at.setRule(r1);
			persist(em,r1,at);
			
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
