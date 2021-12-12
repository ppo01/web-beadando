package web.beadando.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "beadando")
@NamedQuery(name="Person.findAll", query = "select person from Person person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy="person_id", fetch = FetchType.LAZY)
    private List<PersonCompany> personCompanies;

    public Person() {
    }

    public Person(Long personId, String personName, String position, List<PersonCompany> personCompanies) {
        this.personId = personId;
        this.personName = personName;
        this.position = position;
        this.personCompanies = personCompanies;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<PersonCompany> getPersonCompanies() {
        return personCompanies;
    }

    public void setPersonCompanies(List<PersonCompany> personCompanies) {
        this.personCompanies = personCompanies;
    }
}
