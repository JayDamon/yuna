package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bill_sast")
public class BillSast implements MappedBillId<BillSastId> {

    @EmbeddedId
    private BillSastId id;

    @ManyToOne
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "sast_bill_id", insertable = false, updatable = false)
    private Bill sastBill;

    @OneToOne
    @JoinColumn(name = "sast_type_id")
    private SastType sastType;

    public BillSast() {
    }

    public BillSast(Bill bill, Bill sastBill, SastType sastType) {
        this.bill = bill;
        this.sastBill = sastBill;
        this.sastType = sastType;
        this.id = new BillSastId(bill, sastBill);

    }

    public BillSastId getId() {
        return id;
    }

    @Override
    public void setId(BillSastId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Bill getSastBill() {
        return sastBill;
    }

    public void setSastBill(Bill sastBill) {
        this.sastBill = sastBill;
    }

    public SastType getSastType() {
        return sastType;
    }

    public void setSastType(SastType sastType) {
        this.sastType = sastType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillSast billSast = (BillSast) o;
        return Objects.equals(id, billSast.id) &&
                Objects.equals(bill, billSast.bill) &&
                Objects.equals(sastBill, billSast.sastBill) &&
                Objects.equals(sastType, billSast.sastType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bill, sastBill, sastType);
    }

    @Override
    public String toString() {
        return "BillSast{" +
                "id=" + id +
                ", bill=" + bill +
                ", sastBill=" + sastBill +
                ", sastType=" + sastType +
                '}';
    }
}
