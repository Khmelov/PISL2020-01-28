package by.it.group773601.gorodeckaya.l5.java;

import classes.Person;
import classes.Persons;
import classes.PersonSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate.ServiceDAO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class App {
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
                case "6": return;
            }
        }
    }

    public static void menu(){
        System.out.println("Enter: \n" + "1. Record in XML\n" + "2. Save XML in BD\n" +
                "3. Add Person to DB\n" + "4. Record JSON\n" +
                "5. Translator from JSON\n"+ "6. Exit");
    }

    public static void marshaling(){
        try {
            ServiceDAO serviceDAO = ServiceDAO.getInstance();
            Persons persons = new Persons();
            serviceDAO.beginTransaction();
            persons.setList(serviceDAO.getPersons());
            serviceDAO.commit();
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(persons, new FileOutputStream("src/main/resources/person.xml"));
            System.out.println("XML create");
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
            FileReader reader = new FileReader("src/main/resources/person.xml");
            List<Person> personList = ((Persons) unmarshaller.unmarshal(reader)).getPersons();
            serviceDAO.beginTransaction();
            serviceDAO.savePersons(personList);
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
        PersonSet personService = new PersonSet();
        Person person = personService.setPerson();
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
            File file =  new File("src/main/resources/person.json");
            objectMapper.writeValue(file, persons);
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
