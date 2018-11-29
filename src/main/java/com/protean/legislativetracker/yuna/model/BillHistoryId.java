package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillHistoryId implements Serializable, BillId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_body_id")
    private Body body;

    @Column(name = "history_action")
    private String action;

    public BillHistoryId() {
    }

    public BillHistoryId(Bill bill, Body body, String action) {
        this.bill = bill;
        this.body = body;
        this.action = action;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill billId) {
        this.bill = billId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "BillHistoryId{" +
                "bill=" + bill.getBillId() +
                ", body=" + body +
                ", action='" + action + '\'' +
                '}';
    }
}
