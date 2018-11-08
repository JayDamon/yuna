package com.protean.legislativetracker.yuna.repository;

import com.protean.legislativetracker.yuna.model.LegislativeSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SessionRepository extends CrudRepository<LegislativeSession, Integer> {

    boolean existsBySessionIdAndSessionHash(Integer sessionId, String sessionHash);

    LegislativeSession findBySessionIdAndSessionHashNot(Integer sessionId, String sessionHash);

}
