package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import allocation.*;


public class Run {
	public static void createTest(EntityManager em) throws Exception {
		Unit unit1 = new Unit();
		unit1.setIdUnit(1);
		unit1.setName("galão");
		//
		Unit unit2 = new Unit();
		unit2.setIdUnit(2);
		unit2.setName("horas");
		em.persist(unit1);
		em.persist(unit2);
		Unit unidade = new Unit();
		unidade.setName("unidades");
		unidade.setIdUnit(3);
		em.persist(unidade);
		ConsumableType sup1 = new ConsumableType();
		sup1.setIdComsumableType(1);
		sup1.setName("Tinta");
		Location loc = new Location();
		loc.setIdLocation(1);
		em.persist(loc);
		em.persist(sup1);
		Holding hold1 = new Holding();
		hold1.setConsumableType(sup1);
		hold1.setIdHolding(1);
		hold1.setLocation(loc);
		em.persist(hold1);
		
		ConsumableType sup2 = new ConsumableType();
		sup2.setName("Gasolina");
		sup2.setIdComsumableType(2);
		em.persist(sup2);
		ConsumableType sup3 = new ConsumableType();
		sup3.setName("Giz");
		sup3.setIdComsumableType(3);
		em.persist(sup3);
		Holding hold2= new Holding();
		hold2.setConsumableType(sup2);
		hold2.setIdHolding(2);
		hold2.setLocation(loc);
		em.persist(hold2);
		EquipmentType eqtyp1 = new EquipmentType();
		eqtyp1.setEqtypeId(1);
		eqtyp1.setName("Notebook");
		em.persist(eqtyp1);
		//--
		Action act = new Action();
		act.setIdAction(1);
		act.setName("Ação teste 1");
		em.persist(act);
		Consumable com1 = new Consumable();
		com1.setHolding(hold1);
		com1.setAction(act);
		com1.setIdSupplyReq(1);		
		com1.setQuantity(new Quantity(3,unit1));
		em.persist(com1);
		Consumable com2 = new Consumable();
		com2.setHolding(hold2);
		com2.setAction(act);
		com2.setIdSupplyReq(2);		
		com2.setQuantity(new Quantity(8,unit1));
		em.persist(com2);
		EquipmentRequirement equipReq = new EquipmentRequirement();
		equipReq.setAction(act);
		equipReq.setQuantity(new Quantity(2.5,unidade));
		equipReq.setRequirementId(1);
		equipReq.setResourceType(eqtyp1);
		em.persist(equipReq);
		em.flush();
		SupplyRequirement supReq = new SupplyRequirement();
		supReq.setResourceType(sup3);
		supReq.setAction(act);
		//supReq.setIdAction(act);
		supReq.setQuantity(new Quantity(7,unidade));
		em.persist(supReq);
		//--
		
		//--
		em.flush();		
		// Query test:
		// MappedSuperclass SEMPRE precisa do pacote ! caminho completo
		List<ResourceAllocation> res = em.createQuery("From allocation.ResourceAllocation").getResultList();
		for (ResourceAllocation r:res) {
			System.out.println(r+"="+ r.getQuantity().getAmmount());
		}
		em.refresh(supReq);
		supReq.getQuantity().setAmmount(supReq.getQuantity().getAmmount()+1);
		em.flush();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesteJPA2");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
		    tx = em.getTransaction();
		    tx.begin();
		    /*List<Account> acc = em.createQuery("From Account").getResultList();
		    if (acc.size()>0)
		    	System.err.println("siz "+acc.size());
		    else*/
		    	createTest(em);
		    //tx.commit();
		
		    System.out.println("OK");
		} catch (Exception ex) {
			if ( tx != null && tx.isActive() ) 
				tx.rollback();
			ex.printStackTrace();
		    throw new RuntimeException( ex); // or display error message
		} finally {
			em.close();
			emf.close();
		}
	}

}
