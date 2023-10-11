package com.spring.services;

import com.spring.base.BaseServices;
import com.spring.dto.PersonDtoName;
import com.spring.entity.Person;
import com.spring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonService extends BaseServices<Person,Long> {

    private final PersonRepository personRepository;

    @Override
    public Long count() {
        return personRepository.count();
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    public List<Person> findByAge(Byte age) {
        return personRepository.findByAge(age);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void saveAll(List<Person> people) {
        personRepository.saveAll(people);
    }

    @Override
    public void deleteById(Long aLong) {
        personRepository.deleteById(aLong);
    }
}
