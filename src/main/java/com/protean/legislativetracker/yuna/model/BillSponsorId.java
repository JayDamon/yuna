package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillSponsorId implements Serializable, BillId {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "sponsor_order")
    private Integer sponsorOrder;

    public BillSponsorId() {
    }

    public BillSponsorId(Bill bill, Integer sponsorOrder) {
        this.bill = bill;
        this.sponsorOrder = sponsorOrder;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getSponsorOrder() {
        return sponsorOrder;
    }

    public void setSponsorOrder(Integer sponsorOrder) {
        this.sponsorOrder = sponsorOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillSponsorId that = (BillSponsorId) o;
        return Objects.equals(bill, that.bill) &&
                Objects.equals(sponsorOrder, that.sponsorOrder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bill, sponsorOrder);
    }

    @Override
    public String toString() {
        return "BillSponsorId{" +
                "bill=" + bill +
                ", sponsorOrder=" + sponsorOrder +
                '}';
    }
}
