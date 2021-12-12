package web.beadando.persistence.entitymanager;

import web.beadando.persistence.entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDao {
    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(Person t) {
        em.merge(t);
        em.flush();
    }

    public Person findOne(Long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }


    public void delete(Person t) {
        em.remove(t);
    }
}
