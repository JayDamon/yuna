package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.bootstrap.LoadTestData;
import com.protean.legislativetracker.yuna.model.LegislativeSession;
import com.protean.legislativetracker.yuna.repository.SessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testservice.InitialDataService;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionServiceTest {

    @Autowired private DataSource dataSource;
    @Autowired private SessionService sessionService;
    @Autowired private SessionRepository sessionRepository;

    private static boolean initialized = false;

    List<LegislativeSession> existingSessions;
    List<LegislativeSession> savedSessions;

    @Before
    public void setUp() {
        InitialDataService.getInstance().initializeData(dataSource);

        LegislativeSession sessionOne = new LegislativeSession();
        sessionOne.setSessionId(1132);
        sessionOne.setSessionHash("e8ce3086bdb61cd16f4a19371c9f0378");

        LegislativeSession sessionTwo = new LegislativeSession();
        sessionTwo.setSessionId(81);
        sessionTwo.setSessionHash("testChange");

        LegislativeSession sessionThree = new LegislativeSession();
        sessionThree.setSessionId(1258);
        sessionThree.setSessionHash("5f1928427d95f7da73aa827f803ec219");

        LegislativeSession sessionFour = new LegislativeSession();
        sessionFour.setSessionId(1004);
        sessionFour.setSessionHash("testChange2");

        existingSessions = new ArrayList<>(Arrays.asList(sessionOne, sessionTwo, sessionThree, sessionFour));

        LegislativeSession saveSessionOne = new LegislativeSession(1300, 2019, 2020, false,
                "129th Legislature", "129th Legislature", "cbee568f7906a4530387560cc1d0aa67");
        LegislativeSession saveSessionTwo = new LegislativeSession(1400, 2021, 2022, false,
                "129th Legislature", "129th Legislature", "cbee568f7906a4530387560cc1d0aa67");

        savedSessions = new ArrayList<>(Arrays.asList(saveSessionOne, saveSessionTwo));
    }

    @Test
    public void getAllChangedSessions_ValidSessionList_ReturnsChangedSessions() {
        List<LegislativeSession> changedSessions = sessionService.getAllChangedSessions(existingSessions);
        assertNotNull(changedSessions);
        assertEquals(2, changedSessions.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllChangedSessions_NullList_ThrowsIllegalArgumentException() {
        sessionService.getAllChangedSessions(null);
    }

    @Test
    public void saveSessions_ValidSessionList_SavesBills() {
        List<LegislativeSession> returnedSessions = sessionService.saveSessions(savedSessions);
        assertNotNull(returnedSessions);
        assertEquals(2, savedSessions.size());
        assertEquals(1300, returnedSessions.get(0).getSessionId().intValue());
        assertEquals(1400, returnedSessions.get(1).getSessionId().intValue());
        assertTrue(sessionRepository.existsById(1300));
        assertTrue(sessionRepository.existsById(1400));
    }
}