package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillHistoryId implements Serializable, BillId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Column(name = "history_action")
    private String action;

    public BillHistoryId() {
    }

    public BillHistoryId(Bill bill, String action) {
        this.bill = bill;
        this.action = action;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill billId) {
        this.bill = billId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "BillHistoryId{" +
                "bill=" + bill +
                ", action='" + action + '\'' +
                '}';
    }
}
