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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

    public BillSponsorId() {
    }

    public BillSponsorId(Bill bill, Integer sponsorOrder, Person person) {
        this.bill = bill;
        this.sponsorOrder = sponsorOrder;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "BillSponsorId{" +
                "bill=" + bill.getBillId() +
                ", sponsorOrder=" + sponsorOrder +
                ", person=" + person +
                '}';
    }
}
