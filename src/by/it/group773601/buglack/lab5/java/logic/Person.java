package by.it.group773601.buglack.lab5.java.logic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Person",propOrder = {
        "lastName",
        "firstName",
        "thirdName",
        "birthDate",
        "sex",
        "address",
        "passport",
        "nation",
        "reservist"
})
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Person implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @XmlElement(required = true)
    private String lastName;
    @XmlElement(required = true)
    private String firstName;
    @XmlElement(required = true)
    private String thirdName;
    @XmlElement(required = true)
    private Passport passport;
    @XmlElement(required = true)
    private Date birthDate;
    @XmlElement(required = true)
    private String sex;
    @XmlElement(required = true)
    private Address address;
    @XmlElement(required = true)
    @Enumerated(EnumType.STRING)
    private Nationality nation;
    @XmlElement(required = true)
    private boolean reservist;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Nationality getNation() {
        return nation;
    }

    public void setNation(Nationality nation) {
        this.nation = nation;
    }

    public boolean isReservist() {
        return reservist;
    }

    public void setReservist(boolean reservist) {
        this.reservist = reservist;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
