package account;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

public class AccountTest {
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
			
			Unit dolar = new Unit("dolar");
			Unit real = new Unit("real");
			persist(em,dolar,real);
			
			DetailAccount acct1 = new DetailAccount();
			DetailAccount acct2 = new DetailAccount();
			DetailAccount acct3 = new DetailAccount();
			SummaryAccount sacct1 = new SummaryAccount();
			
			persist(em,acct1,acct2,acct3,sacct1);
			
			sacct1.getComponents().add(acct1);
			sacct1.getComponents().add(acct3);
			
			Transaction trans1 =acct1.newDeposit(acct2, new Quantity(250,dolar));
			Transaction trans2 = acct2.newDeposit(acct1, new Quantity(500,dolar));
			Transaction trans3 = acct2.newDeposit(acct3, new Quantity(1500.0,dolar));
			
			persist(em,trans1,trans2,trans3);
			
			
			Transaction mtrans = new Transaction();
			mtrans.newEntry(acct1, new Quantity(100,dolar));
			mtrans.newEntry(acct2, new Quantity(-200,dolar));
			mtrans.newEntry(acct3, new Quantity(100,dolar));
			
			persist(em,mtrans);
			
			em.flush();
			/*
			tx.commit();
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();*/
			
			SummaryAccount sac = em.createQuery("select act from SummaryAccount as act",SummaryAccount.class).getSingleResult();
			System.out.println("Summary account:"+sac.getNumber());
			for (Account act:sac.getComponents()) {
				System.out.println(" component accounts:"+act.getNumber());
			}
			System.out.println("summary balance "+sac.balance());
			assertEquals(-1550.0, sac.getLastBalance().getAmount(),0.1);
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
