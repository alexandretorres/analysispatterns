package teste;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		ConsumableAllocation com1 = new ConsumableAllocation();
		com1.setHolding(hold1);
		com1.setAction(act);
		//com1.setIdSupplyReq(1);		
		com1.setQuantity(new Quantity(3,unit1));
		em.persist(com1);
		ConsumableAllocation com2 = new ConsumableAllocation();
		com2.setHolding(hold2);
		com2.setAction(act);
		//com2.setIdSupplyReq(2);		
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
		em.refresh(act);
		
		Post professor = new Post();
		professor.setIdPost(1);
		professor.setName("Professor of OO");
		em.persist(professor);
		Post speaker = new Post();
		speaker.setIdPost(2);
		speaker.setName("Speaker");
		em.persist(speaker);

		Employee booch = new Employee();
		booch.setIdEmployee(1);
		booch.setStart(new Date());
		em.persist(booch);
		em.flush();
		//em.refresh(booch);
		booch.setTypes(new HashSet<Post>());
		booch.getTypes().add(professor);
		booch.getTypes().add(speaker);
		booch.setName("G. Booch");
		AssignedEmployee assignedSpeaker = new AssignedEmployee();
		assignedSpeaker.setEmployee(booch);
		assignedSpeaker.setIdAssignment(1);
		assignedSpeaker.setQuantity(new Quantity(3,unit2));	
		
		act.getResources().add(assignedSpeaker);
		em.persist(assignedSpeaker);
		
		WorkRequirement profReq = new WorkRequirement();
		profReq.setResourceType(professor);
		profReq.setQuantity(new Quantity(20,unit2));
		profReq.setRequirementId(1);
		em.persist(profReq);
		act.getResources().add(profReq);
		em.flush();
		//---
		System.out.println("\nUsing UNION getter ****************");
		for (ResourceAllocation r:act.getResources()) {
			System.out.println(r+"="+ r.getQuantity().getAmmount());
		}
		
		// Query test:
		// MappedSuperclass SEMPRE precisa do pacote ! caminho completo
		System.out.println("\nUsing SELECT FROM MappedSuperClass ****************");
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
	public static void testa(Set<? extends ResourceAllocation> set) {
		
	}
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
