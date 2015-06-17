/**
 * 
 */
package demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.gembro.model.Bien;
import com.gembro.model.Proprietaire;

/**
 * @author quocanh
 *
 */
public class DemoHibernate {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	/**
	 * @param args
	 */
	
	public static void runHibernateDemo() {
        // A SessionFactory is set up once for an application
        SessionFactory sessionFactory = createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();        
        
        Query query1 = session.createQuery("select count(distinct p.nom) from " + Proprietaire.class.getName() + " p where p.nom like '%guyen%'");
        System.out.println("So luong ket qua la: " + query1.list());
        
        query1 = session.createQuery("from " + Proprietaire.class.getName() + " p where p.nom like '%guyen%'");
        query1.setMaxResults(10);		
        @SuppressWarnings("unchecked")
        List<Proprietaire> result = query1.list();
        for (Proprietaire proprietaire : result) {
        	System.out.println(proprietaire.getNom() + " " + proprietaire.getPrenom());
        }
        
        String select = "select b from " + Bien.class.getName() + " b inner join b.proprietaire";
        Query query = session.createQuery(select);
        query.setReadOnly(true);
        query.setFirstResult(1); // take 1 that represents the first row in the result set
        query.setMaxResults(10); // retrieve a fixed number maxResults of objects
        @SuppressWarnings("unchecked")        
		List<Bien> lstBiens = query.list();
        for (Bien bien : lstBiens) {
        	System.out.println(bien.getAdresse() + " " + bien.getCp() + " " + bien.getVille() + ": " + bien.getProprietaire().getNom());
        }
        
        session.getTransaction().commit();
        session.close();

	}
	
	/**
	 * Create  a new sessionFactory
	 * @return
	 */
    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        try {
            sessionFactory = new Configuration()
        	.addAnnotatedClass(Proprietaire.class)
        	.addAnnotatedClass(Bien.class)
        	.configure()
        	.buildSessionFactory(serviceRegistry);        	
        } catch (Throwable ex) {
        	System.err.println("Failed to create sessionFactory object." + ex);
        	throw new ExceptionInInitializerError(ex); 
        }

        return sessionFactory;
    }
    
    
}
