package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.repository.SessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testservice.InitialDataService;

import javax.sql.DataSource;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionServiceImplTest {

    @Autowired private DataSource dataSource;
    @Autowired private SessionRepository sessionRepository;
    private SessionService sessionService;

    @Before
    public void setUp() {
        InitialDataService.getInstance().initializeData(dataSource);
        this.sessionService = new SessionServiceImpl(sessionRepository);
    }

    @Test
    public void getSessionIds_ReturnsSessionIds() {
        Set<Integer> ids = sessionService.getSessionIds();
        assertNotNull(ids);
        assertFalse(ids.isEmpty());
        assertEquals(5, ids.size());
    }
}