package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillSastId implements Serializable, BillId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sast_bill_id")
    private Bill sastBillId;

    public BillSastId() {
    }

    public BillSastId(Bill bill, Bill sastBillId) {
        this.bill = bill;
        this.sastBillId = sastBillId;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Bill getSastBillId() {
        return sastBillId;
    }

    public void setSastBillId(Bill sastBillId) {
        this.sastBillId = sastBillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillSastId that = (BillSastId) o;
        return Objects.equals(bill, that.bill) &&
                Objects.equals(sastBillId, that.sastBillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill, sastBillId);
    }

    @Override
    public String toString() {
        return "BillSastId{" +
                "bill=" + bill +
                ", sastBillId=" + sastBillId +
                '}';
    }
}
