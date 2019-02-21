package com.protean.legislativetracker.yuna.repository;

import com.protean.legislativetracker.yuna.model.RollCall;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface RollCallRepository extends CrudRepository<RollCall, Long> {
}
