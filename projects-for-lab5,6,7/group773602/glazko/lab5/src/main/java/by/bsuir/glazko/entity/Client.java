package by.bsuir.glazko.entity;

import by.bsuir.glazko.util.adapter.DateAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    @Column(name = "last_name")
    @XmlElement(name = "lastName")
    private String lastName;

    @Column(name = "first_name")
    @XmlElement(name = "firstName")
    private String firstName;

    @Column(name = "patronymic_name")
    @XmlElement(name = "patronymicName")
    private String patronymicName;

    @Column(name = "birth_date")
    @XmlElement(name = "birthDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date birthDate;

    @Column(name = "passport_series")
    @XmlElement(name = "passportSeries")
    private String passportSeries;

    @Column(name = "passport_number")
    @XmlElement(name = "passportNumber")
    private String passportNumber;

    @Id
    @Column(name = "passport_personal_number")
    @XmlElement(name = "passportPersonalNumber")
    private String passportPersonalNumber;

    @ManyToOne
    @JoinColumn(name = "residence_city_code")
    @XmlElement(name = "city")
    private City residenceCity;

    @Column(name = "residence_address")
    @XmlElement(name = "residenceAddress")
    private String residenceAddress;

    @Column(name = "mobile_phone")
    @XmlElement(name = "mobilePhone")
    private String mobilePhone;

    @Column(name = "email")
    @XmlElement(name = "email")
    private String email;

    @Column(name = "employed")
    @XmlElement(name = "employed")
    private boolean employed;

    @Column(name = "work_position")
    @XmlElement(name = "workPosition")
    private String workPosition;

    @Column(name = "registration_address")
    @XmlElement(name = "registrationAddress")
    private String registrationAddress;

    @ManyToOne
    @JoinColumn(name = "citizenship_code")
    @XmlElement(name = "country")
    private Country citizenship;
}