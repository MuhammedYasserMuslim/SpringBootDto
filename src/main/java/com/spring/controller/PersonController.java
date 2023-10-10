package com.spring.controller;

import com.spring.dto.PersonDto;
import com.spring.entity.Person;
import com.spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")

public class PersonController {

    @Autowired
    PersonService personService;
    @GetMapping("/count")
    public Long count(){
        return personService.count();
    }
    @GetMapping("/persons")
    public List<PersonDto> finaAll(){
        List<Person> persons= personService.findAll();
        List<PersonDto> personsDtos= new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            PersonDto personDto = new PersonDto();
            personDto.setName(persons.get(i).getName());
            personDto.setSalary(persons.get(i).getSalary());
            personsDtos.add(personDto);
        }
        return personsDtos;
    }



    @GetMapping("/person")
    public Optional<Person> findById(@RequestParam Long id){
        return personService.findById(id);
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
    public Person deleteById(Long id){
        Person person = personService.findById(id).get();
        personService.deleteById(id);
        return person;

    }


}
