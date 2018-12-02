package com.protean.legislativetracker.yuna.repository;

import com.protean.legislativetracker.yuna.model.Committee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommitteeRepository extends CrudRepository<Committee, Integer> {
}
