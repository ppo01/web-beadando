package web.beadando.persistence.entitymanager;

import web.beadando.persistence.entity.Company;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CompanyDao {

    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(Company c) {
        em.merge(c);
        em.flush();
    }

    public void delete(Company c) {
        em.remove(c);
    }

    public Company findOne(Long company_id) {
        return em.find(Company.class, company_id);
    }

    public List<Company> findAll() {
        return em.createNamedQuery("Company.findAll", Company.class).getResultList();
    }
}
