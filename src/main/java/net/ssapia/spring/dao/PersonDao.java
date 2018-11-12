package net.ssapia.spring.dao;

import net.ssapia.spring.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long> {

}
