package net.ssapia.spring.controller;

import net.ssapia.spring.dao.PersonDao;
import net.ssapia.spring.dao.PersonDaoHB;
import net.ssapia.spring.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonDaoHB personDaoHB;

    @DeleteMapping("/persons/{id}")
    private ResponseEntity<String> delete(@PathVariable("id") Long id) {

        try {
            personDao.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    private ResponseEntity<Person> get(@PathVariable("id") Long id) {
        Optional<Person> personOptional = personDao.findById(id);
        if (personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.get());
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/persons")
    private ResponseEntity<Iterable<Person>> list() {
        return ResponseEntity.ok(personDao.findAll());
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(personDao.save(person));
    }

    @PutMapping("/persons")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return ResponseEntity.ok(personDaoHB.save(person));
    }


}


