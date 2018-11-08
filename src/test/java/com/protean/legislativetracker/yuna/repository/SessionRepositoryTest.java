package com.protean.legislativetracker.yuna.repository;

import com.protean.legislativetracker.yuna.bootstrap.LoadTestData;
import com.protean.legislativetracker.yuna.model.LegislativeSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testservice.InitialDataService;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionRepositoryTest {

    @Autowired private SessionRepository sessionRepository;
    @Autowired private DataSource dataSource;

    private static boolean initialized = false;

    @Before
    public void setUp() {
        InitialDataService.getInstance().initializeData(dataSource);
    }

    @Test
    public void existsBySessionIdAndSessionHash_UnchangedSession_SessionFound() {
        assertTrue(sessionRepository.existsBySessionIdAndSessionHash(
                1132, "e8ce3086bdb61cd16f4a19371c9f0378"));
    }

    @Test
    public void existsBySessionIdAndSessionHash_ChangedSession_SessionNotFound() {
        assertFalse(sessionRepository.existsBySessionIdAndSessionHash(
                81, "changedHash"));
    }

    @Test
    public void findBySessionIdAndSessionHash_ChangedHash_SessionReturned() {
        LegislativeSession session = sessionRepository.findBySessionIdAndSessionHashNot(1132, "changedHash");
        assertEquals(1132, session.getSessionId().intValue());
        assertEquals("ME", session.getState().getAbbreviation());
    }

}
