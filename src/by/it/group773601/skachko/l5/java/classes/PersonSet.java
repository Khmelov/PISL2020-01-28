package skachko.l5.java.classes;

import classes.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PersonSet {
    public Person setPerson()  {
        Person p = new Person();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Firstname: ");
                p.setFirstName(scanner.nextLine());
                System.out.println("Lastname: ");
                p.setLastName(scanner.nextLine());
                System.out.println("Patronymic: ");
                p.setPatronymic(scanner.nextLine());
                System.out.println("Birthday date(yyyy-MM-dd): ");
                String date = scanner.nextLine();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                p.setBirthDate(ft.parse(date));
                System.out.println("Sex: ");
                p.setSex(scanner.nextLine());
                System.out.println("Nationality: ");
                p.setNation(setNationality());
                Address address = new Address();
                System.out.println("Now address: ");
                address.setNowAddress(scanner.nextLine());
                System.out.println("Now city: ");
                address.setNowCity(setCity());
                System.out.println("Registration city: ");
                address.setRegistrationCity(setCity());
                System.out.println("Phone: ");
                address.setPhone(scanner.nextLine());
                System.out.println("Mobile Phone: ");
                address.setMobphone(scanner.nextLine());
                p.setAddress(address);
                Passport passport = new Passport();
                System.out.println("ID passport: ");
                passport.setIdNumber(Long.parseLong(scanner.nextLine()));
                System.out.println("# passport");
                passport.setNumber(Integer.parseInt(scanner.nextLine()));
                System.out.println("Seria passport: ");
                passport.setSeries(scanner.nextLine());
                p.setPassport(passport);
            } catch (ParseException ex) {
                System.out.println("Failed input date");
                continue;
            }
            return p;
        }
    }

    private Nationality setNationality(){
        System.out.println("1. Belarus\n2. Russian\n3. Ukrain\n");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextLine()){
            case "1": return Nationality.belarus;
            case "2": return Nationality.russian;
            case "3": return Nationality.ukrain;
        }
        return Nationality.belarus;
    }

    private City setCity(){
        System.out.println("1. Brest\n2. Vitebsk\n3. Grodno\n4. Gomel\n5. Minsk\n");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextLine()){
            case "1": return City.Brest;
            case "2": return City.Vitebsk;
            case "3": return City.Grodno;
            case "4": return City.Gomel;
            case "5": return City.Minsk;
        }
        return City.Minsk;
    }
}
