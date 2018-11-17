package com.protean.legislativetracker.yuna.service;

import com.protean.legislativetracker.yuna.model.Bill;

import java.util.List;


public interface BillService {

    boolean billHasChanged(Long billId, String changeHash);

    List<Bill> saveBills(List<Bill> bills);

}
