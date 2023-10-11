package com.spring.controller;

import com.spring.dto.PersonDto;
import com.spring.dto.PersonDtoName;
import com.spring.entity.Person;
import com.spring.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    @GetMapping("/count")
    public Long count(){
        return personService.count();
    }
    @GetMapping("/persons")
    public List<PersonDto> finaAll(){
        List<Person> persons= personService.findAll();
        List<PersonDto> personsDtos= new ArrayList<>();
        for (Person person : persons) {
            PersonDto personDto = new PersonDto();
            personDto.setName(person.getName());
            personDto.setSalary(person.getSalary());
            personsDtos.add(personDto);
        }
        return personsDtos;
    }



    @GetMapping("/person")
    public Optional<PersonDtoName> findById(@RequestParam Long id){

        Person person = new Person();
        PersonDtoName personDtoName = new PersonDtoName();
        personDtoName.setName(personService.findById(id).get().getName());
        return Optional.of(personDtoName);
    }
    @GetMapping("/personn")
    public List<Person> findByAge(@RequestParam Byte age ){
        return personService.findByAge(age);
    }

    @PostMapping("/person")
    public Person insert(@RequestBody Person person){
        personService.save(person);
        return person;
    }

    @PutMapping ("/person")
    public Person update(@RequestBody Person person) {
        personService.save(person);
        return person;
    }

    @PatchMapping ("/person")
    public Person updatePatch(@RequestBody Person person) {
        personService.save(person);
        return person;
    }

    @DeleteMapping("/person")
    public Optional<Person> deleteById(Long id){
        Optional<Person> person = personService.findById(id);
        personService.deleteById(id);
        return person;

    }


}
