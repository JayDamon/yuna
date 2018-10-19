package com.protean.legislativetracker.yuna.repositories;

import com.protean.legislativetracker.yuna.model.LegislativeSession;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<LegislativeSession, Integer> {
}
