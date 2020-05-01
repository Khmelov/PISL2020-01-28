package by.it.group773601.leshchinskaya.jpa.logic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum// для enum
public enum Nationality {

    //описываются элементы перечесления
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
