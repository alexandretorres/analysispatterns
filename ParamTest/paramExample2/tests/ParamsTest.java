package tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import paramtst.Owner;
import paramtst.OwnerA;
import paramtst.OwnerB;
import paramtst.Property;
import paramtst.PropertyA;
import paramtst.PropertyB;

public class ParamsTest {
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
			OwnerA o1 = new OwnerA();
			persist(em,o1);
			PropertyA pa= new PropertyA();
			persist(em,pa);
			//o1.getProperties().add(pa);
			pa.setOwner(o1);
			
			Property<OwnerB> pr = new Property<OwnerB>();
			//persist(em,pr); won´t work
			OwnerB o2 = new OwnerB();
			persist(em,o2);
			//pr.setOwner(o2);
			PropertyB pb = new PropertyB();
			persist(em,pb);
			pb.setOwner(o2);
			
			em.flush();
			
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
