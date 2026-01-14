package addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddressBook {
	private CompanyComparator companyComparator;
	private PersonComparator personComparator;
	static private EntityManagerFactory managerFactory = Persistence
			.createEntityManagerFactory("AddressJPA");
	private EntityManager manager = null;

	public AddressBook(int numberOfPersons, int numberOfCompanies) {
		personComparator = new PersonComparator();
		companyComparator = new CompanyComparator();
	}

	public EntityManager getManager() {
		if (manager == null || !manager.isOpen()) {
			manager = managerFactory.createEntityManager();
		}
		return manager;
	}

	public void close() {
		if (manager != null && manager.isOpen()) {
			manager.close();
		}
	}

	public void saveData() {
		EntityManager em = getManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.flush();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public void deleteAllData(){
		EntityManager em = getManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.createQuery("DELETE FROM Telephone").executeUpdate();
			em.createQuery("DELETE FROM Person").executeUpdate();
			em.createQuery("DELETE FROM Company").executeUpdate();			
			em.flush();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public void addCompany(Company newCompany) {
		EntityManager em = getManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(newCompany);
			em.flush();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public void addPerson(Person newPerson) {
		EntityManager em = getManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(newPerson);
			em.flush();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public void removeCompany(Company newCompany) {
		EntityManager em = getManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(newCompany);
			em.flush();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public void removePerson(Person newPerson) {
		EntityManager em = getManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(newPerson);
			em.flush();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public Company findCompanyByName(String name) {
		Iterator<Company> iterator = getCompanies().iterator();
		Company companyToFind;
		while (iterator.hasNext()) {
			companyToFind = iterator.next();
			if (companyToFind.getName() == name)
				return companyToFind;
		}
		return null;
	}

	/*
	 * vc pode fazer uma comparação ignorando maiusculas com
	 * personToFind.getName().equalsIgnoreCase(name)
	 */
	public Person findPersonByName(String name) {
		Iterator<Person> iterator = getPersons().iterator();
		Person personToFind;
		while (iterator.hasNext()) {
			personToFind = iterator.next();
			if (personToFind.getName() == name)
				return personToFind;
		}
		return null;
	}

	public SortedSet<Company> getCompaniesByFirstLetter(char letter) {
		TreeSet<Company> companiesWithSameFirstLetter = new TreeSet<Company>(
				companyComparator);
		;
		Iterator<Company> iterator = getCompanies().iterator();
		Company companyToFind;
		while (iterator.hasNext()) {
			companyToFind = iterator.next();
			if (companyToFind.getName().charAt(0) > letter)
				break;
			if (companyToFind.getName().charAt(0) == letter) {
				companiesWithSameFirstLetter.add(companyToFind);
			}
		}
		return Collections.unmodifiableSortedSet(companiesWithSameFirstLetter);
	}

	public SortedSet<Person> getPersonsByFirstLetter(char letter) {
		TreeSet<Person> personsWithSameFirstLetter = new TreeSet<Person>(
				personComparator);
		;
		Iterator<Person> iterator = getPersons().iterator();
		Person personToFind;
		while (iterator.hasNext()) {
			personToFind = iterator.next();
			if (personToFind.getName().charAt(0) > letter)
				break;
			if (personToFind.getName().charAt(0) == letter) {
				personsWithSameFirstLetter.add(personToFind);
			}
		}
		return Collections.unmodifiableSortedSet(personsWithSameFirstLetter);
	}

	public List<Person> getPersons() {
		EntityManager em = getManager();
		return em.createQuery(
				"select pers from Person as pers order by pers.IdPerson",
				Person.class).getResultList();
	}

	public List<Company> getCompanies() {
		EntityManager em = getManager();
		return em.createQuery(
				"select comp from Company as comp order by comp.IdCompany",
				Company.class).getResultList();
	}
}
