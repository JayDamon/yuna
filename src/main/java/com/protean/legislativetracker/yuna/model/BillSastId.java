package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillSastId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill billId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sast_bill_id")
    private Bill sastBillId;

    public BillSastId() {
    }

    public BillSastId(Bill billId, Bill sastBillId) {
        this.billId = billId;
        this.sastBillId = sastBillId;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
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
        return Objects.equals(billId, that.billId) &&
                Objects.equals(sastBillId, that.sastBillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, sastBillId);
    }

    @Override
    public String toString() {
        return "BillSastId{" +
                "billId=" + billId +
                ", sastBillId=" + sastBillId +
                '}';
    }
}
