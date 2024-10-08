package br.com.erudio.rest_with_spring_boot_and_java_erudio.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.Services.PersonService;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.model.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(
        method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll() throws Exception {
        return personService.findAll();
    }

    @RequestMapping(
        value = "/{id}", 
        method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(
            @PathVariable(value = "id") String id
        ) throws Exception {

        return personService.findById(id);
    }

    @RequestMapping(
        value = "/{id}", 
        method=RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person) throws Exception {

        return personService.create(person);
    }

    @RequestMapping(
        value = "/{id}", 
        method=RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person) throws Exception {

        return personService.update(person);
    }

    @RequestMapping(
        value = "/{id}", 
        method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void delete(
            @PathVariable(value = "id") String id
        ) throws Exception {

        personService.delete(id);
    }
}
