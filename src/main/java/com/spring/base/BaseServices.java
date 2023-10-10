package com.spring.base;

import jakarta.persistence.MappedSuperclass;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseServices<T,ID> {

    BaseRepository<T,ID> baseRepository;

    public Long count(){
        return baseRepository.count();
    }

    public List<T> findAll(){
        return baseRepository.findAll();
    }

    public Optional<T> findById(ID id){
        return baseRepository.findById(id);
    }

    public void save(T t){
        baseRepository.save(t);
    }

    public void saveAll(List<T> ts){
        baseRepository.saveAll(ts);
    }
    public void deleteById(ID id){
        baseRepository.deleteById(id);
    }
}
