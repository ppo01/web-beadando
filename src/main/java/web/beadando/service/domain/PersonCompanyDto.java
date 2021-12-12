package web.beadando.service.domain;

import java.util.Date;
import java.util.Objects;

public class PersonCompanyDto {

    private Long person_company_id;
    private PersonDto person_id;
    private CompanyDto company_id;
    private Date date;

    public PersonCompanyDto() {
    }

    public PersonCompanyDto(Long person_company_id, PersonDto person_id, CompanyDto company_id, Date date) {
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

    public PersonDto getPerson_id() {
        return person_id;
    }

    public void setPerson_id(PersonDto person_id) {
        this.person_id = person_id;
    }

    public CompanyDto getCompany_id() {
        return company_id;
    }

    public void setCompany_id(CompanyDto company_id) {
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
        PersonCompanyDto that = (PersonCompanyDto) o;
        return Objects.equals(person_company_id, that.person_company_id) && Objects.equals(person_id, that.person_id) && Objects.equals(company_id, that.company_id) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_company_id, person_id, company_id, date);
    }

    @Override
    public String toString() {
        return "PersonCompanyDto{" +
                "person_company_id=" + person_company_id +
                ", person_id=" + person_id +
                ", company_id=" + company_id +
                ", date=" + date +
                '}';
    }
}
