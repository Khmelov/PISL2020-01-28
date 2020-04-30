package by.it.group773601.leshchinskaya.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate.ServiceDAO;
import logic.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while(true){
            menu();
            switch (scanner.nextLine()){
                case "1": marshaling(); break;
                case "2": unmarshaling(); break;
                case "3": addPerson(); break;
                case "4": toJSON(); break;
                case "5": fromJSON(); break;
                case "6": System.exit(0);
            }
        }
    }

    public static void menu(){
        System.out.println("Выберите: \n" +
                "1. Записать в XML\n" +
                "2. Сохраненить из XML в БД\n" +
                "3. Добавить человека в БД\n" +
                "4. Записать в JSON\n" +
                "5. Преобразование из JSON\n"+
                "6. Выход");
    }

    public static void marshaling(){
        try {
            ServiceDAO serviceDAO = ServiceDAO.getInstance();//получаем объект класса
            Persons persons = new Persons();
            serviceDAO.beginTransaction();//начало транзакции
            persons.setList(serviceDAO.getPersons());//выполнение запроса по поиску всех пользователей
            serviceDAO.commit();//выполнение транзакции
            JAXBContext context = JAXBContext.newInstance(Persons.class);//получение JAXBContext для класса Persons
            Marshaller m = context.createMarshaller();// создание Marshaller
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);//JAXB_FORMATTED_OUTPUT означает, что XML генерируется с прав. отступами
            m.marshal(persons, new FileOutputStream("src/main/resources/person.xml"));//просиходит генерация XML-файла
            System.out.println("XML файл создан");
            m.marshal(persons, System.out);
        }
        catch (FileNotFoundException e ) {
            e.printStackTrace();
        }
        catch (JAXBException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unmarshaling(){
        try {
            ServiceDAO serviceDAO = ServiceDAO.getInstance();
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("src/main/resources/person.xml");//считывание из файлва
            List<Person> personList = ((Persons) unmarshaller.unmarshal(reader)).getPersons();// преобразование в java-объекты
            serviceDAO.beginTransaction();
            serviceDAO.savePersons(personList);//сохранение объектов в базу
            serviceDAO.commit();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPerson(){
        PersonService personService = new PersonService();
        Person person = personService.setPerson();//создание пользователя
        ServiceDAO serviceDAO = ServiceDAO.getInstance();
        try {
            serviceDAO.beginTransaction();
        serviceDAO.savePerson(person);
        serviceDAO.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void toJSON(){
        ServiceDAO serviceDAO = ServiceDAO.getInstance();
        Persons persons = new Persons();
        try {
            serviceDAO.beginTransaction();
        persons.setList(serviceDAO.getPersons());
        serviceDAO.commit();
        ObjectMapper objectMapper = new ObjectMapper();
        File file =  new File("src/main/resources/person.json");//создание файла для записи JSON
        objectMapper.writeValue(file, persons);// парсинг в JSON
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fromJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file =  new File("src/main/resources/person.json");
        try {
            System.out.println(objectMapper.readValue(file, Persons.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
