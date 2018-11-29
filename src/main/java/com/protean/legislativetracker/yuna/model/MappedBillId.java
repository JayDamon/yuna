package com.protean.legislativetracker.yuna.model;

public interface MappedBillId<T extends BillId> extends MappedBill {

    void setId(T billId);

    T getId();

}
