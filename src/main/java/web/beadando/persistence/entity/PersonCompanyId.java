package web.beadando.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class PersonCompanyId {

    @Column(name = "person_id")
    private Long personId;
    @Column(name = "company_id")
    private Long companyId;

    public PersonCompanyId() {
    }


    public PersonCompanyId(Long personId, Long companyId) {
        this.personId = personId;
        this.companyId = companyId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
