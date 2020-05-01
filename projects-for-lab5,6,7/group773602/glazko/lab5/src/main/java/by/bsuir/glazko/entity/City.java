package by.bsuir.glazko.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @Id
    @Column(name = "city_code")
    @XmlElement(name = "cityCode")
    private String cityCode;

    @Column(name = "city_name")
    @XmlElement(name = "cityName")
    private String cityName;
}