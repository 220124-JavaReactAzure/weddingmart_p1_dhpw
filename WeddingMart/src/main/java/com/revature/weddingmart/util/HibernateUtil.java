package com.revature.weddingmart.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.revature.weddingmart.models.Asset;
import com.revature.weddingmart.models.AssetType;
import com.revature.weddingmart.models.MealChoice;
import com.revature.weddingmart.models.MealOrder;
import com.revature.weddingmart.models.MealOrderPlusOne;
import com.revature.weddingmart.models.Wedding;
import com.revature.weddingmart.models.users.Attendee;
import com.revature.weddingmart.models.users.Betrothed;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static Session getSession() throws IOException {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties props = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("hibernate.properties"));
			
			// Add properties to our configuration
			configuration.setProperties(props);
			// add annotated classes
			configuration.addAnnotatedClass(Asset.class);
			configuration.addAnnotatedClass(AssetType.class);
			configuration.addAnnotatedClass(MealChoice.class);
			configuration.addAnnotatedClass(MealOrder.class);
			configuration.addAnnotatedClass(MealOrderPlusOne.class);
			configuration.addAnnotatedClass(Wedding.class);
			configuration.addAnnotatedClass(Attendee.class);
			configuration.addAnnotatedClass(Betrothed.class);
	
			// ServiceRegistry
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		if(session == null) {
			session = sessionFactory.openSession();
		}
		
		return session;
	}
	
	public static void closeSession() {
		session.close();
		session = null;
		
	}
	
}
