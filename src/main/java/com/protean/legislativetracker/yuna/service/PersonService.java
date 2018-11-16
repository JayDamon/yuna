package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Person;

import java.util.List;

public interface PersonService {

    boolean personHasChanged(Long personId, String personChangeHash);

    List<Person> savePeople(List<Person> people);
}
