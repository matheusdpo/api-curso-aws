package br.com.udemy.cursoapi.services.v1;

import br.com.udemy.cursoapi.DozerMapper;
import br.com.udemy.cursoapi.controller.RestControllerApiCursoPersonv2;
import br.com.udemy.cursoapi.model.Person;
import br.com.udemy.cursoapi.repository.PersonRepository;
import br.com.udemy.cursoapi.vo.v1.PersonVOv1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.udemy.cursoapi.DozerMapper.parseListObjects;
import static br.com.udemy.cursoapi.DozerMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServicesv1 {

    private Logger logger = Logger.getLogger("LOG CARALHO");

    @Autowired
    private PersonRepository personRepository;

    //v1
    public PersonVOv1 findById(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));

        PersonVOv1 vo = parseObject(entity, PersonVOv1.class);
        vo.add(linkTo(methodOn(RestControllerApiCursoPersonv2.class).findById(id)).withSelfRel());
        return vo;
    }

    public List<PersonVOv1> findAll() {
        return parseListObjects(personRepository.findAll(), PersonVOv1.class);
    }


    public PersonVOv1 create(PersonVOv1 PersonVO) {

        var entity = parseObject(PersonVO, Person.class);

        return parseObject(personRepository.save(entity), PersonVOv1.class);
    }

    public PersonVOv1 update(PersonVOv1 personVO) {
        var entity = personRepository.findById(personVO.getKey()).orElseThrow(() -> new RuntimeException("Erro"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setGender(personVO.getGender());

        return parseObject(personRepository.save(entity), PersonVOv1.class);
    }

    public void delete(Long id) {
        logger.info("Deleting a PersonVO...");
        personRepository.deleteById(id);
    }

}