package by.it.group773601.gorodeckaya.l5.java.hibernate;

import classes.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
        private static SessionFactory sessionFactory;
        static {
            try {
                Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
                cfg.addAnnotatedClass(Person.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties());
                sessionFactory = cfg.buildSessionFactory(builder.build());
            }
            catch (Throwable ex){
                System.err.println("Initial SessionFactory creation failed" + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        static SessionFactory getSessionFactory(){
            return sessionFactory;
        }
}
