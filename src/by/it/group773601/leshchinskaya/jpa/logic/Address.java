package by.it.group773601.leshchinskaya.jpa.logic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.*;

@XmlRootElement//корневой элемент
@XmlAccessorType(XmlAccessType.FIELD)//обозначает что должно быть серилизовано
@XmlType(name="Address", propOrder = {//задает порядок следования полей
        "actualCity",
        "actualAddress",
        "phone",
        "releaseAddress"
})
@Embeddable//используется, чтобы обозначить что класс будет частью другого класса
@Data// аннотация lombok, которая будет определять конструкторы, геттеры и сеттеры, ToString и т.д.
public class Address {
    @Enumerated(EnumType.STRING)//описывает, что это enum
    private City actualCity;
    private String actualAddress;
    private String phone;
    private String releaseAddress;

    public City getActualCity() {
        return actualCity;
    }

    public void setActualCity(City actualCity) {
        this.actualCity = actualCity;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReleaseAddress() {
        return releaseAddress;
    }

    public void setReleaseAddress(String releaseAddress) {
        this.releaseAddress = releaseAddress;
    }
}
