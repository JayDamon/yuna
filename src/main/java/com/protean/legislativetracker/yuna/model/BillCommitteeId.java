package com.protean.legislativetracker.yuna.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillCommitteeId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "committee_id")
    private Integer committeeId;

    public BillCommitteeId() {
    }

    public BillCommitteeId(Bill bill, Integer committeeId) {
        this.bill = bill;
        this.committeeId = committeeId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Integer committeeId) {
        this.committeeId = committeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillCommitteeId that = (BillCommitteeId) o;
        return Objects.equals(bill, that.bill) &&
                Objects.equals(committeeId, that.committeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill, committeeId);
    }

    @Override
    public String toString() {
        return "BillCommitteeId{" +
                "bill=" + bill.getBillId() +
                ", committeeId=" + committeeId +
                '}';
    }
}
