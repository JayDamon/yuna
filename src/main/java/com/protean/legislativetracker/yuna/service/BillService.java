package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Bill;

import java.util.List;


public interface BillService {

    List<Bill> getAllChangedBills(List<Bill> bills);

    List<Bill> saveBills(List<Bill> bills);

}
