package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Committee;

import java.util.Set;

public interface CommitteeService {

    void saveAll(Set<Committee> committees);

    boolean existsById(Integer id);

}
