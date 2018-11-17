package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Bill;
import com.protean.legislativetracker.yuna.model.Person;
import com.protean.legislativetracker.yuna.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean personHasChanged(Long personId, String personChangeHash) {
        return !personRepository.existsByIdAndPersonHash(personId, personChangeHash);
    }

    @Override
    public List<Person> savePeople(List<Person> people) {
        List<Person> savedPeople = new ArrayList<>();
        personRepository.saveAll(people).forEach(savedPeople::add);
        return savedPeople;
    }
}
