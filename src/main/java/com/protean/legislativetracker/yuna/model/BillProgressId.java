package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BillProgressId implements Serializable, BillId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "progress_step")
    private Integer progressStep;

    public BillProgressId() {
    }

    public BillProgressId(Bill bill, Integer progressStep) {
        this.bill = bill;
        this.progressStep = progressStep;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getProgressStep() {
        return progressStep;
    }

    public void setProgressStep(Integer progressStep) {
        this.progressStep = progressStep;
    }

    @Override
    public String toString() {
        return "BillProgressId{" +
                "bill=" + bill.getBillId() +
                ", progressStep=" + progressStep +
                '}';
    }
}
