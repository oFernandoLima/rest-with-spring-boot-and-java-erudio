package br.com.erudio.rest_with_spring_boot_and_java_erudio.Services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.data.vo.v1.PersonVO;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.mapper.Mapper;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.model.Person;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.repositories.PersonRepository;

@Service
public class PersonService {

    public Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<PersonVO> findAll() throws Exception {
        logger.info("Finding all people!");

        return Mapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        logger.info("Finding one person!");

        var entity = personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        return Mapper.parseObject(entity, PersonVO.class);

    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var entity = Mapper.parseObject(person, Person.class);
        var vo = Mapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");

        var entity = personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = Mapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.delete(entity);
    }
}
