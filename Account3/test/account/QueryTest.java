package account;


	import static org.junit.Assert.*;

	import java.util.Date;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;

	import org.junit.Test;

	public class QueryTest {
		public void persist(EntityManager em,Object... objs) {
			for (Object ob:objs) {
				em.persist(ob);
			}
		}
		@Test
		public void test() {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("Account3");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try {
				
				tx = em.getTransaction();
				tx.begin();
				
				SummaryAccount sac = em.createQuery("select act from SummaryAccount as act",SummaryAccount.class).getSingleResult();
				for (Account act:sac.getComponents()) {
					System.out.println(act.getNumber());
				}
				System.out.println("sumary balance "+sac.balance());
				for (Entry ent:sac.getEntries()) {
					System.out.println("entry "+ent.getQuantity());
				}
				List<Account> acts = em.createQuery("select act from Account as act", Account.class).getResultList();
				for (Account act:acts) {
					System.out.println(act.getNumber());
					for (Entry ent:act.getEntries()) {
						System.out.println("   entry "+ent.getAccount().getNumber()+","+ent.getTransaction().getId()+"," +ent.getQuantity());
					}
					System.out.println(" balance:"+act.balance());
				}
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


