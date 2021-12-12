package web.beadando.persistence.entitymanager;


import web.beadando.persistence.entity.PersonCompany;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonCompanyDao {

    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(PersonCompany t) {
        em.merge(t);
        em.flush();
    }

    public PersonCompany findOne(Long person_company_id) {
        return em.find(PersonCompany.class, person_company_id);
    }

    public List<PersonCompany> findAll() {
        return em.createNamedQuery("PersonCompany.findAll", PersonCompany.class).getResultList();
    }








}
