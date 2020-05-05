package classes;

import javax.xml.bind.annotation.*;

@XmlType
@XmlEnum
public enum Nationality {
    @XmlEnumValue("belarus") belarus("belarus"),
    @XmlEnumValue("russian") russian("russian"),
    @XmlEnumValue("ukrain") ukrain("ukrain");

    private String value;

    Nationality(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
