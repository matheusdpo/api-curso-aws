package br.com.udemy.cursoapi.controller;

import br.com.udemy.cursoapi.services.v1.PersonServicesv1;
import br.com.udemy.cursoapi.vo.v1.PersonVOv1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/PersonVO")
public class RestControllerApiCursoPerson {

    @Autowired
    private PersonServicesv1 personServicesv1;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVOv1 findById(@PathVariable(value = "id") Long id) {
        return personServicesv1.findById(id);
    }

    @PostMapping()
    public PersonVOv1 create(@RequestBody PersonVOv1 PersonVO) {
        return personServicesv1.create(PersonVO);
    }

    @PutMapping()
    public PersonVOv1 update(@RequestBody PersonVOv1 PersonVO) {
        return personServicesv1.update(PersonVO);
    }

    @GetMapping
    public List<PersonVOv1> findAll() {
        return personServicesv1.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personServicesv1.delete(id);
        return ResponseEntity.noContent().build();
    }

}