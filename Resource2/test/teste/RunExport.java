package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
public class RunExport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("Resource2");
		// this stupid module only works with an Hibernate.cfg file! shoot yourself!
		EntityManager em = emf.createEntityManager();
		Configuration cfg = new Configuration();
		
		cfg.buildSessionFactory();
		new SchemaExport(cfg).create(true, false);

	}

}
