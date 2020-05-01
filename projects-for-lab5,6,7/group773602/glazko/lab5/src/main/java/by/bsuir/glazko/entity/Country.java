package by.bsuir.glazko.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {

    @Id
    @Column(name = "country_code")
    @XmlElement(name = "countryCode")
    private String countryCode;

    @Column(name = "country_name")
    @XmlElement(name = "countryName")
    private String countryName;
}