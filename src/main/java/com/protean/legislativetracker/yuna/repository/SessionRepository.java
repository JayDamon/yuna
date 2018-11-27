package com.protean.legislativetracker.yuna.repository;

import com.protean.legislativetracker.yuna.model.LegislativeSession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface SessionRepository extends CrudRepository<LegislativeSession, Integer> {

    boolean existsBySessionIdAndSessionHash(Integer sessionId, String sessionHash);

    LegislativeSession findBySessionIdAndSessionHashNot(Integer sessionId, String sessionHash);

    @Query(value = "SELECT session_id FROM session", nativeQuery = true)
    Set<Integer> findAllSessionIds();

}
