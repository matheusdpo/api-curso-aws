package br.com.udemy.cursoapi.vo.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

@JsonPropertyOrder(value = {"identificação", "primeiro nome", "segundo nome", "genero"})
public class PersonVOv1 extends RepresentationModel<PersonVOv1> {

    @JsonProperty("identificação")
    @Mapping("id")
    private Long key;

    @JsonProperty("primeiro nome")
    private String firstName;

    @JsonProperty("segundo nome")
    private String lastName;

    @JsonProperty("genero")
    private String gender;


    public PersonVOv1() {
    }

    public PersonVOv1(Long key, String firstName, String lastName, String gender) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Long getKey() {
        return key;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVOv1 person = (PersonVOv1) o;
        return Objects.equals(key, person.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}
