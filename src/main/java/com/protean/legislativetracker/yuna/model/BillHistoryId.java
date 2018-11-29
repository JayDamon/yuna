package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillHistoryId implements Serializable, BillId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Column(name = "history_id")
    private Integer historyStep;

    public BillHistoryId() {
    }

    public BillHistoryId(Bill bill, Integer historyStep) {
        this.bill = bill;
        this.historyStep = historyStep;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill billId) {
        this.bill = billId;
    }

    public Integer getHistoryStep() {
        return historyStep;
    }

    public void setHistoryStep(Integer historyStep) {
        this.historyStep = historyStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillHistoryId that = (BillHistoryId) o;
        return Objects.equals(bill, that.bill) &&
                Objects.equals(historyStep, that.historyStep);
    }

    @Override
    public String toString() {
        return "BillHistoryId{" +
                "bill=" + bill.getBillId() +
                ", historyStep=" + historyStep +
                '}';
    }
}
