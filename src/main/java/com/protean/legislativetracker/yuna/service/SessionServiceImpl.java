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
    public List<LegislativeSession> getAllChangedSessions(List<LegislativeSession> sessions) {
        if (sessions == null) {
            String msg = "Session list must not be null";
            log.debug(msg);
            throw new IllegalArgumentException(msg);
        }
        List<LegislativeSession> changedSessions = new ArrayList<>();
        for (LegislativeSession s : sessions) {
            if (!sessionRepository.existsBySessionIdAndSessionHash(s.getSessionId(), s.getSessionHash())) {
                changedSessions.add(s);
            }
        }
        return changedSessions;
    }

    @Override
    public List<LegislativeSession> saveSessions(List<LegislativeSession> sessions) {
        List<LegislativeSession> savedSessions = new ArrayList<>();
        sessionRepository.saveAll(sessions).forEach(savedSessions::add);
        return savedSessions;
    }
}
