package com.protean.legislativetracker.yuna.repository;

import com.protean.legislativetracker.yuna.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {

    boolean existsByIdAndPersonHash(Long personId, String sessionHash);

    Person findByIdAndPersonHashNot(Long personId, String personHash);

}
