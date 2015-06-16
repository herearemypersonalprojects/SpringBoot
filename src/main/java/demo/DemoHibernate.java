/**
 * 
 */
package demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
	public static void main(String[] args) {
        // A SessionFactory is set up once for an application
        SessionFactory sessionFactory = createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();        
        Query query = session.createQuery("from " + Proprietaire.class.getName() + " p where p.nom like '%guyen%'");
		@SuppressWarnings("unchecked")
		List<Proprietaire> result = query.list();
        for (Proprietaire proprietaire : result) {
        	System.out.println(proprietaire.getNom() + " " + proprietaire.getPrenom());
        }
        session.getTransaction().commit();
        session.close();

	}
    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = new Configuration()
        	.addAnnotatedClass(Proprietaire.class)
        	.configure()
        	.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
}
