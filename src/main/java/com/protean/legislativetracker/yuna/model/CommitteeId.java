package com.protean.legislativetracker.yuna.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CommitteeId implements Serializable, BillId {

    @Column(name = "committee_id", nullable = false)
    private Integer committeeId;
    @Column(name = "bill_id")
    private Bill bill;

    public CommitteeId() {
    }

    public CommitteeId(Integer committeeId, Bill bill) {
        this.committeeId = committeeId;
        this.bill = bill;
    }

    @Override
    public void setBill(Bill bill) {
    }

    public Integer getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Integer committeeId) {
        this.committeeId = committeeId;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return "CommitteeId{" +
                "committeeId=" + committeeId +
                ", bill=" + bill.getBillId() +
                '}';
    }
}
