package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.LegislativeSession;

import java.util.List;

public interface SessionService {

    boolean sessionHasChanged(Integer sessionId, String changeHash);

    List<LegislativeSession> saveSessions(List<LegislativeSession> sessions);

}
