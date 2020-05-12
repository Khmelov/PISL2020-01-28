package by.it.group773601.romashko.JAXB+JPA5.java.classes;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Passport", propOrder = {
        "series",
        "number",
        "idNumber"
})
@Embeddable
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Passport {
    private String series;
    private int number;
    private long idNumber;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }
}
