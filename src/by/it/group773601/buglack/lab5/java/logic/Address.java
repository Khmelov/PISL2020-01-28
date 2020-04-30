package by.it.group773601.buglack.lab5.java.logic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Address", propOrder = {
        "actualCity",
        "actualAddress",
        "phone",
        "releaseAddress"
})
@Embeddable
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {
    @Enumerated(EnumType.STRING)
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
