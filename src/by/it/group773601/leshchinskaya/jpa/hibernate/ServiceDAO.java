package by.it.group773601.leshchinskaya.jpa.hibernate;

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
            session = HibernateUtil.getSessionFactory().openSession();//открытие сессии для начала транзакции
            session.beginTransaction();
        }
        else session.beginTransaction();
    }

    public void commit() {
            session.getTransaction().commit();//выполнение транзакции
    }

    public void rollback() throws Exception{
        session.getTransaction().rollback();//откат транзакции
    }

    public List<Person> getPersons() throws Exception {
        return (List<Person>) session.createQuery("select p from logic.Person p").list();//получение всех пользователей из бд
    }

    public Person finById(long id){
        return session.find(Person.class, id);//поиск пользователя по id
    }

    public void savePerson(Person p){
        session.save(p);//сохранение пользователя
    }

    public void savePersons(List<Person> personList){
        personList.forEach(e -> session.save(e));//сохранение всех пользователей
    }

    public void close(){
        session.close();//закрытие сессии
    }

}
