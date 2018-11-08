package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Bill;
import com.protean.legislativetracker.yuna.repository.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

    private BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> getAllChangedBills(List<Bill> bills) {
        if (bills == null) {
            String msg = "Bill list must not be null";
            log.debug(msg);
            throw new IllegalArgumentException(msg); }
        List<Bill> changedBills = new ArrayList<>();
        for (Bill b : bills) {
            if (!billRepository.existsByBillIdAndChangeHash(b.getBillId(), b.getChangeHash())) {
                changedBills.add(b);
            }
        }
        return changedBills;
    }

    @Override
    public List<Bill> saveBills(List<Bill> bills) {
        List<Bill> savedBills = new ArrayList<>();
        billRepository.saveAll(bills).forEach(savedBills::add);
        return savedBills;
    }
}
