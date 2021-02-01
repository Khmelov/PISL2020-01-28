package classes;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Address", propOrder = {
        "nowCity",
        "nowAddress",
        "phone",
        "mobphone",
        "registrationCity"
})
@Embeddable
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {
    @Enumerated(EnumType.STRING)
    private City nowCity;
    private String nowAddress;
    private String phone;
    private String mobphone;
    @Enumerated(EnumType.STRING)
    private City registrationCity;

    public City getNowCity() {
        return nowCity;
    }

    public void setNowCity(City nowCity) {
        this.nowCity = nowCity;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobphone() {
        return mobphone;
    }

    public void setMobphone(String mobphone) {
        this.mobphone = mobphone;
    }

    public City getRegistrationCity() {
        return registrationCity;
    }

    public void setRegistrationCity(City registrationCity) {
        this.registrationCity = registrationCity;
    }
}
