package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillHistoryId implements Serializable, BillId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Column(name = "history_order")
    private Integer order;

    public BillHistoryId() {
    }

    public BillHistoryId(Bill bill, Integer order) {
        this.bill = bill;
        this.order = order;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill billId) {
        this.bill = billId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BillHistoryId{" +
                "bill=" + bill.getBillId() +
                ", order=" + order +
                '}';
    }
}
