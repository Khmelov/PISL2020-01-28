package by.it.group773601.buglack.lab5.java.hibernate;

import logic.Person;
import org.hibernate.Session;

import java.util.List;

public class ServiceDAO {

    private static ServiceDAO organizationDAO;
    private Session session;

    private ServiceDAO(){
    }

    public static ServiceDAO getInstance(){
        if (organizationDAO == null){
            organizationDAO = new ServiceDAO();
        }
        return organizationDAO;
    }

    public void beginTransaction() throws Exception {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        }
        else session.beginTransaction();
    }

    public void commit() {
            session.getTransaction().commit();
    }

    public void rollback() throws Exception{
        session.getTransaction().rollback();
    }

    public List<Person> getPersons() throws Exception {
        return (List<Person>) session.createQuery("select p from logic.Person p").list();
    }

    public Person finById(long id){
        return session.find(Person.class, id);
    }

    public void savePerson(Person p){
        session.save(p);
    }

    public void savePersons(List<Person> personList){
        personList.forEach(e -> session.save(e));
    }

    public void close(){
        session.close();
    }

}
