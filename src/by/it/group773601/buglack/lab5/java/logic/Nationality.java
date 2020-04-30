package by.it.group773601.buglack.lab5.java.logic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum Nationality {
    @XmlEnumValue("Беларус") BELARUS("Беларус"),
    @XmlEnumValue("Россиянин") RUSSIAN("Россиянин"),
    @XmlEnumValue("Украинец") UKRAIN("Украинец");

    private String value;

    Nationality(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
