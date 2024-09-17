package br.com.udemy.cursoapi.mapper;

import br.com.udemy.cursoapi.model.Person;
import br.com.udemy.cursoapi.vo.v2.PersonVOv2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DozerMapperCustomizer {

    public static PersonVOv2 convertPersonToPersonVov2(Person person) {
        PersonVOv2 personVOv2 = new PersonVOv2();

        personVOv2.setId(person.getId());
        personVOv2.setFirstName(person.getFirstName());
        personVOv2.setLastName(person.getLastName());
        personVOv2.setGender(person.getGender());
        personVOv2.setBirthDay(new Date());

        return personVOv2;
    }

    public static List<PersonVOv2> convertPersonToPersonVov2List(List<Person> personList) {
        List<PersonVOv2> personVOv2List = new ArrayList<>();

        for (Person person : personList) {
            PersonVOv2 personVOv2 = convertPersonToPersonVov2(person);

            personVOv2List.add(personVOv2);
        }

        return personVOv2List;
    }

    public static Person convertPersonVoV2ToPerson(PersonVOv2 personVOv2) {
        Person person = new Person();

        person.setId(personVOv2.getId());
        person.setFirstName(personVOv2.getFirstName());
        person.setLastName(personVOv2.getLastName());
        person.setGender(personVOv2.getGender());

        return person;
    }

}
