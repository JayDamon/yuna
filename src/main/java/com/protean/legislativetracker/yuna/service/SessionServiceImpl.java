package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.LegislativeSession;
import com.protean.legislativetracker.yuna.repository.SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private Logger log = LoggerFactory.getLogger(SessionServiceImpl.class);

    private SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public boolean sessionHasChanged(Integer sessionId, String changeHash) {
        return sessionRepository.existsBySessionIdAndSessionHash(sessionId, changeHash);
    }

    @Override
    public List<LegislativeSession> saveSessions(List<LegislativeSession> sessions) {
        List<LegislativeSession> savedSessions = new ArrayList<>();
        sessionRepository.saveAll(sessions).forEach(savedSessions::add);
        return savedSessions;
    }
}
