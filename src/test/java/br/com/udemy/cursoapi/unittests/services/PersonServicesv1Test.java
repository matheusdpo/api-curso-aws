package br.com.udemy.cursoapi.unittests.services;

import br.com.udemy.cursoapi.model.Person;
import br.com.udemy.cursoapi.repository.PersonRepository;
import br.com.udemy.cursoapi.services.v1.PersonServicesv1;
import br.com.udemy.cursoapi.unittests.mapper.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesv1Test {

    MockPerson input;

    @InjectMocks
    private PersonServicesv1 personServicesv1;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUpMocks() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Person person = input.mockEntity();
        person.setId(1L);
        Mockito.when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        var result = personServicesv1.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("self"));
    }

    @Test
    void finAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}