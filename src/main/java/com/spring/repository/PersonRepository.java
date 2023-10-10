package com.spring.repository;


import com.spring.base.BaseRepository;
import com.spring.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends BaseRepository<Person,Long> {

    public List<Person> findByAge(Byte age);
}
