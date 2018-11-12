package net.ssapia.spring.dao;

import net.ssapia.spring.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDaoHB {

    @PersistenceContext
    private EntityManager em;

    public Person save(Person person) {
        //if (person.getId() == null) {
            em.persist(person);
            return person;
        //} else {
        //    return em.merge(person);
        //}
    }
}
