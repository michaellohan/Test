package ie.gmit.project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;





public class HibUtil {
	 private static final SessionFactory sessionFactory = buildSessionFactory();
	 private static SessionFactory buildSessionFactory() {
	  try {
		  
		  
		  Configuration configuration = new Configuration();
		  configuration.addAnnotatedClass(Person.class);
		  configuration.addAnnotatedClass(Student.class);
		

		  configuration.configure();
		  ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		  return configuration.buildSessionFactory(serviceRegistry);
		  

	  }
	  catch (Throwable ex) {
	   // need to log the exception, as it might be swallowed
	   System.err.println("Initial SessionFactory creation failed." + ex);
	   throw new ExceptionInInitializerError(ex);
	  }
	 }
	 public static SessionFactory getSessionFactory() {
	  return sessionFactory;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
