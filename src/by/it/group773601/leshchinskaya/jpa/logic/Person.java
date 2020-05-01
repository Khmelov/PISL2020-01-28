package by.it.group773601.leshchinskaya.jpa.logic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;


@XmlRootElement//корневой элемент
@XmlAccessorType(XmlAccessType.FIELD)//обозначает что должно быть серилизовано
@XmlType(name="Person",propOrder = {//задает порядок следования полей
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
@Data// аннотация lombok, которая будет определять конструкторы, геттеры и сеттеры, ToString и т.д.
@Entity// аннотация для связи с таблицой в бд
public class Person implements Serializable {
    @XmlTransient//для игнорирования этого поля в XML
    @Id// для обозначения id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//для автогенерации первичного ключа
    private long id;
    @XmlElement(required = true)// для обозначения элемента для xml
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



}
