package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill_history")
public class BillHistory implements MappedBillId<BillHistoryId> {

    @EmbeddedId
    private BillHistoryId id = new BillHistoryId();

    @ManyToOne
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;
    @Column(name = "history_major")
    private Integer historyMajor;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_body_id")
    private Body body;
    @Column(name = "history_date")
    private Date date;
    @Column(name = "history_action", columnDefinition = "text")
    private String action;


    public BillHistory() {
    }

    public BillHistory(Bill bill, Integer historyMajor, Body body, Date date, String action, Integer order) {
        this.bill = bill;
        this.historyMajor = historyMajor;
        this.body = body;
        this.date = date;
        this.action = action;
        this.id = new BillHistoryId(bill, order);
    }

    @Override
    public BillHistoryId getId() {
        return id;
    }

    @Override
    public void setId(BillHistoryId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getHistoryMajor() {
        return historyMajor;
    }

    public void setHistoryMajor(Integer historyMajor) {
        this.historyMajor = historyMajor;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "BillHistory{" +
                "id=" + id +
                ", bill=" + bill.getBillId() +
                ", historyMajor=" + historyMajor +
                ", body=" + body +
                ", date=" + date +
                ", action='" + action + '\'' +
                '}';
    }
}
