package br.com.udemy.cursoapi.controller;

import br.com.udemy.cursoapi.services.v2.PersonServicesv2;
import br.com.udemy.cursoapi.vo.v2.PersonVOv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v2/PersonVO")
public class RestControllerApiCursoPersonv2 {

    @Autowired
    private PersonServicesv2 personServicesv2;

    @GetMapping("{id}")
    public PersonVOv2 findById(@PathVariable(value = "id") Long id) {
        return personServicesv2.findById(id);
    }

    @PostMapping()
    public PersonVOv2 create(@RequestBody PersonVOv2 personVO) {
        return personServicesv2.create(personVO);
    }

    @PutMapping()
    public PersonVOv2 update(@RequestBody PersonVOv2 personVO) {
        return personServicesv2.update(personVO);
    }

    @GetMapping()
    public List<PersonVOv2> findAll() {
        return personServicesv2.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personServicesv2.delete(id);
        return ResponseEntity.noContent().build();
    }

}