package br.com.erudio.apigateway.services;

import br.com.erudio.apigateway.controller.PersonController;
import br.com.erudio.apigateway.exceptions.RequiredObjectIsNullException;
import br.com.erudio.apigateway.exceptions.ResourceNotFoundException;
import br.com.erudio.apigateway.mapper.custom.PersonMapper;
import br.com.erudio.apigateway.model.Person;
import br.com.erudio.apigateway.vo.v1.PersonVO;
import br.com.erudio.apigateway.mapper.DozerMapper;
import br.com.erudio.apigateway.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll() {

        logger.info("Finding all people!");

        var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
        persons.stream().forEach(p ->p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }

    public PersonVO findById(Long id) {

        logger.info("Finding one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PersonVO create(PersonVO person) {

        if(person == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }


    public PersonVO update(PersonVO person) {

        if(person == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one person!");

        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirtName(person.getFirtName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}