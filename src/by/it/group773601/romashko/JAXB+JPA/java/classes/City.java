package by.it.group773601.romashko.JAXB+JPA.java.classes;

import javax.xml.bind.annotation.*;

@XmlType
@XmlEnum
public enum City {
    @XmlEnumValue("Minsk") Minsk("Minsk"),
    @XmlEnumValue("Grodno") Grodno("Grodno"),
    @XmlEnumValue("Gomel") Gomel("Gomel"),
    @XmlEnumValue("Vitebsk") Vitebsk("Vitebsk"),
    @XmlEnumValue("Brest") Brest("Brest");

    private String value;

    City(String s){
        this.value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
