package web.beadando.persistence.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "person_company", schema = "beadando")
@NamedQuery(name = "PersonCompany.findAll", query = "select personCompany from PersonCompany personCompany")
public class PersonCompany implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_company_id")
    private Long person_company_id;

    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person_id;
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company_id;
    @Column(name = "date")
    private Date date;

    public PersonCompany() {
    }

    public PersonCompany(Long person_company_id, Person person_id, Company company_id, Date date) {
        this.person_company_id = person_company_id;
        this.person_id = person_id;
        this.company_id = company_id;
        this.date = date;
    }

    public Long getPerson_company_id() {
        return person_company_id;
    }

    public void setPerson_company_id(Long person_company_id) {
        this.person_company_id = person_company_id;
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public Company getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Company company_id) {
        this.company_id = company_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCompany that = (PersonCompany) o;
        return Objects.equals(person_company_id, that.person_company_id) && Objects.equals(person_id, that.person_id) && Objects.equals(company_id, that.company_id) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_company_id, person_id, company_id, date);
    }

    @Override
    public String toString() {
        return "PersonCompany{" +
                "person_company_id=" + person_company_id +
                ", person_id=" + person_id +
                ", company_id=" + company_id +
                ", date=" + date +
                '}';
    }
}
