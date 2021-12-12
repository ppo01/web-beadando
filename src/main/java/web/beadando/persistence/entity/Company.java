package web.beadando.persistence.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "beadando")
@NamedQuery(name="Company.findAll", query = "select company from Company company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "address")
    private String address;
    @Column(name = "main_activity")
    private String mainActivity;

    @OneToMany(mappedBy="company_id", fetch = FetchType.LAZY)
    private List<PersonCompany> personCompanies;

    public Company() {
    }

    public Company(Long companyId, String companyName, String address, String mainActivity, List<PersonCompany> personCompanies) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.address = address;
        this.mainActivity = mainActivity;
        this.personCompanies = personCompanies;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(String mainActivity) {
        this.mainActivity = mainActivity;
    }

    public List<PersonCompany> getPersonCompanies() {
        return personCompanies;
    }

    public void setPersonCompanies(List<PersonCompany> personCompanies) {
        this.personCompanies = personCompanies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyId, company.companyId) && Objects.equals(companyName, company.companyName) && Objects.equals(address, company.address) && Objects.equals(mainActivity, company.mainActivity) && Objects.equals(personCompanies, company.personCompanies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, address, mainActivity, personCompanies);
    }


    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", mainActivity='" + mainActivity + '\'' +
                ", personCompanies=" + personCompanies +
                '}';
    }
}
