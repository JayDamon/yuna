package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Bill;
import com.protean.legislativetracker.yuna.model.Committee;
import com.protean.legislativetracker.yuna.repository.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BillServiceImpl implements BillService {

    private Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

    private BillRepository billRepository;
    private CommitteeService committeeService;

    public BillServiceImpl(BillRepository billRepository, CommitteeService committeeService) {
        this.billRepository = billRepository;
        this.committeeService = committeeService;
    }

    @Override
    public boolean billHasChanged(Long billId, String changeHash) {
        return !billRepository.existsByBillIdAndChangeHash(billId, changeHash);
    }

    @Override
    public List<Bill> saveBills(List<Bill> bills) {
        List<Bill> savedBills = new ArrayList<>();
        Set<Committee> committees = new HashSet<>();
        for (Bill bill : bills) {
            Committee committee = bill.getCommittee();
            if (committee != null && committeeService.existsById(committee.getId())) {
                committees.add(committee);
            }
        }
        committeeService.saveAll(committees);
        billRepository.saveAll(bills).forEach(savedBills::add);
        return savedBills;
    }
}
