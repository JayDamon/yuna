package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillHistoryId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill billId;
    @Column(name = "history_step")
    private Integer historyStep;

    public BillHistoryId() {
    }

    public BillHistoryId(Bill billId, Integer historyStep) {
        this.billId = billId;
        this.historyStep = historyStep;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
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
        return Objects.equals(billId, that.billId) &&
                Objects.equals(historyStep, that.historyStep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, historyStep);
    }

    @Override
    public String toString() {
        return "BillHistoryId{" +
                "billId=" + billId +
                ", historyStep=" + historyStep +
                '}';
    }
}
