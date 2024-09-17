package br.com.udemy.cursoapi.services.v2;

import br.com.udemy.cursoapi.DozerMapper;
import br.com.udemy.cursoapi.mapper.DozerMapperCustomizer;
import br.com.udemy.cursoapi.model.Person;
import br.com.udemy.cursoapi.repository.PersonRepository;
import br.com.udemy.cursoapi.vo.v2.PersonVOv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServicesv2 {

    private Logger logger = Logger.getLogger("LOG CARALHO");

    @Autowired
    private PersonRepository personRepository;

    //v2
    public PersonVOv2 findById(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));

        return DozerMapperCustomizer.convertPersonToPersonVov2(entity);
    }

    public List<PersonVOv2> findAll() {
        return DozerMapperCustomizer.convertPersonToPersonVov2List(personRepository.findAll());
    }


    public PersonVOv2 create(PersonVOv2 PersonVO) {
        var entity = DozerMapper.parseObject(PersonVO, Person.class);

        return DozerMapperCustomizer.convertPersonToPersonVov2(personRepository.save(entity));
    }

    public PersonVOv2 update(PersonVOv2 personVO) {
        var entity = personRepository.findById(personVO.getId()).orElseThrow(() -> new RuntimeException("Erro"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setGender(personVO.getGender());

        return DozerMapperCustomizer.convertPersonToPersonVov2(personRepository.save(entity));
    }

    public void delete(Long id) {
        logger.info("Deleting a PersonVO...");
        personRepository.deleteById(id);
    }

}