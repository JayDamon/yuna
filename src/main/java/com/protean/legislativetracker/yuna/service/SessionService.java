package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.LegislativeSession;

import java.util.List;

public interface SessionService {

    List<LegislativeSession> getAllChangedSessions(List<LegislativeSession> sessions);

    List<LegislativeSession> saveSessions(List<LegislativeSession> sessions);

}
