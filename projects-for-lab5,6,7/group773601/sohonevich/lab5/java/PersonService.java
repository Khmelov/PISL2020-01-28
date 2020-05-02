import logic.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PersonService {

    public Person setPerson()  {
        Person p = new Person();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Имя: ");
                p.setFirstName(scanner.nextLine());
                System.out.println("Фамилия: ");
                p.setLastName(scanner.nextLine());
                System.out.println("Отчество: ");
                p.setThirdName(scanner.nextLine());
                System.out.println("Дата рождения: ");
                String date = scanner.nextLine();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                p.setBirthDate(ft.parse(date));
                System.out.println("Пол: ");
                p.setSex(scanner.nextLine());
                System.out.println("Национальность: ");
                p.setNation(setNationality());
                Address address = new Address();
                System.out.println("Актуальный адресс: ");
                address.setActualAddress(scanner.nextLine());
                System.out.println("Город: ");
                address.setActualCity(setCity());
                System.out.println("Адресс прописки: ");
                address.setReleaseAddress(scanner.nextLine());
                System.out.println("Номер телефона: ");
                address.setPhone(scanner.nextLine());
                p.setAddress(address);
                Passport passport = new Passport();
                System.out.println("Идентификационный номер паспорта: ");
                passport.setIdNumber(scanner.nextLine());
                System.out.println("Номер паспорта");
                passport.setNumber(scanner.nextLine());
                System.out.println("Серия: ");
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
        System.out.println("1. Беларус\n2. Россиянин\n3. Украинец\n");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextLine()){
            case "1": return Nationality.BELARUS;
            case "2": return Nationality.RUSSIAN;
            case "3": return Nationality.UKRAINIAN;
        }
        return Nationality.BELARUS;
    }

    private City setCity(){
        System.out.println("1. Минск\n2. Гродно\n3. Гомель\n4. Витебск\n5. Брест\n");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextLine()){
            case "1": return City.MINSK;
            case "2": return City.GRODNO;
            case "3": return City.GOMEL;
            case "4": return City.VITEBSK;
            case "5": return City.BREST;
        }
        return City.MINSK;
    }


}
