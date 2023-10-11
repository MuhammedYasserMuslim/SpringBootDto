package com.spring.controller;

import com.spring.dto.PersonDto;
import com.spring.dto.PersonDtoName;
import com.spring.entity.Person;
import com.spring.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final ModelMapper modelMapper;
    @GetMapping("/count")
    public Long count(){
        return personService.count();
    }
    @GetMapping("/persons")
    public List<PersonDto> finaAll(){
        List<Person> persons= personService.findAll();
        List<PersonDto> personsDtos= new ArrayList<>();
        for (Person person : persons) {
            PersonDto personDto =modelMapper.map(person,PersonDto.class);
            personsDtos.add(personDto);
        }
        return personsDtos;
    }



    @GetMapping("/person")
    public PersonDtoName findById(@RequestParam Long id){

        Person person = personService.findById(id).get();
        PersonDtoName personDtoName = modelMapper.map(person,PersonDtoName.class);
        return personDtoName;
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
