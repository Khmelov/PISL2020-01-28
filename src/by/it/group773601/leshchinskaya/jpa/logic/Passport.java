package by.it.group773601.leshchinskaya.jpa.logic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement//корневой элемент
@XmlAccessorType(XmlAccessType.FIELD)//обозначает что должно быть серилизовано
@XmlType(name = "Passport", propOrder = {//задает порядок следования полей
        "series",
        "number",
        "idNumber"
})
@Embeddable//используется, чтобы обозначить что класс будет частью другого класса
@Data// аннотация lombok, которая будет определять конструкторы, геттеры и сеттеры, ToString и т.д.
public class Passport {
    private String series;
    private String number;
    private String idNumber;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
