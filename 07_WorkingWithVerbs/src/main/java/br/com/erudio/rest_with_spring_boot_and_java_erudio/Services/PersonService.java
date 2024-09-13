package br.com.erudio.rest_with_spring_boot_and_java_erudio.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.model.Person;

@Service
public class PersonService {
    
    private final AtomicLong counter = new AtomicLong();

    public Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() throws Exception {
        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);  
        }

        return persons;
    }

    public Person findById(String id) {

        logger.info("Finding one person!");
        
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name" + i);
        person.setLastName("Last Name" + i);
        person.setAddress("Brasil" + i);
        person.setGender("Male");
        return person;
    }
}
