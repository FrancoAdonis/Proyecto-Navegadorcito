/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author desarrollo
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
         //   sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
         // SE CAMBIA POR:
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        } catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("SessionFactory - Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }       
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
