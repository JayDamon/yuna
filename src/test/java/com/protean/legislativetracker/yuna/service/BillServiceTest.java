package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.bootstrap.LoadTestData;
import com.protean.legislativetracker.yuna.model.*;
import com.protean.legislativetracker.yuna.repository.BillRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testservice.InitialDataService;

import javax.sql.DataSource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {

    @Autowired BillService billService;
    @Autowired BillRepository billRepository;
    @Autowired private DataSource dataSource;

    private static boolean initialized = false;
    List<Bill> bills;
    List<Bill> billsToSave;

    @Before
    public void setUp() throws MalformedURLException {

        InitialDataService.getInstance().initializeData(dataSource);

        Bill bill1 = new Bill();
        bill1.setBillId(668005L);
        bill1.setChangeHash("340974b96947ee285e9d940928178d1d");

        Bill bill2 = new Bill();
        bill2.setBillId(668130L);
        bill2.setChangeHash("ChangedHash1");

        Bill bill3 = new Bill();
        bill3.setBillId(668041L);
        bill3.setChangeHash("2c5acfd34770dc1090e629ce8e21a3b6");

        Bill bill4 = new Bill();
        bill4.setBillId(668223L);
        bill4.setChangeHash("ChangedHash2");

        Bill bill5 = new Bill();
        bill5.setBillId(668265L);
        bill5.setChangeHash("868828faf922208cd231b6079e3da414");

        Bill bill6 = new Bill();
        bill6.setBillId(668086L);
        bill6.setChangeHash("ChangedHash3");

        Bill bill7 = new Bill();
        bill7.setBillId(668174L);
        bill7.setChangeHash("1f4fc74ba359905e3a265dc509f6c202");

        Bill bill8 = new Bill();
        bill8.setBillId(668309L);
        bill8.setChangeHash("ChangedHash4");

        bills =  new ArrayList<>();
        bills.addAll(Arrays.asList(bill1, bill2, bill3, bill4, bill5, bill6, bill7, bill8));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2008, 05, 05);
        Date date = new Date(calendar.getTimeInMillis());

        State state = new State(19, "ME", "Maine", true, "Augusta");
        LegislativeSession session = new LegislativeSession(48, 2009, 2010, false,
                "124th Legislature", "124th Legislature", "cbee568f7906a4530387560cc1d0aa67");
        Role role = new Role(1, "Representative", "Rep");
        Body body = new Body(47, state, role, 'h', "House of Representatives");
        Type type = new Type(0, "Committee Bill", "CB");
        Progress progress = new Progress(1, "Introduced");
        Bill billOne = new Bill(100001L, state, session, body, body, type, "LDT1", progress, date,
                "Test Bill Title", "Test Bill Description",
                new URL("https://testlegiscanurl.com"), new URL("https://teststateurl.com"),
                "testChangeHash", calendar, calendar);
        Bill billTwo = new Bill(100002L, state, session, body, body, type, "LDT2", progress, date,
                "Test Bill Title 2", "Test Bill Description 2",
                new URL("https://testlegiscanurl.com"), new URL("https://teststateurl.com"),
                "testChangeHash2", calendar, calendar);

        billsToSave = new ArrayList<>();
        billsToSave.add(billOne);
        billsToSave.add(billTwo);
    }

    @Test
    public void getAllChangedBills_ValidBillList_ReturnsChangedBills() {
        List<Bill> actualBills = billService.getAllChangedBills(bills);
        assertNotNull(actualBills);
        assertEquals(4, actualBills.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllChangedBills_NullList_ThrowsIllegalArgumentExsception() {
        billService.getAllChangedBills(null);
    }

    @Test
    public void saveBills_ValidBillList_SavesBills() {

        List<Bill> returnedBills = billService.saveBills(billsToSave);
        assertNotNull(returnedBills);
        assertEquals(2, returnedBills.size());
        assertEquals(100001, returnedBills.get(0).getBillId().intValue());
        assertEquals(100002, returnedBills.get(1).getBillId().intValue());
        assertTrue(billRepository.existsById(100001L));
        assertTrue(billRepository.existsById(100002L));
    }
}