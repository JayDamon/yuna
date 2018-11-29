package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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


    public BillHistory() {
    }

    public BillHistory(Bill bill, Integer historyMajor, Body body, Date date, String action) {
        this.bill = bill;
        this.historyMajor = historyMajor;
        this.body = body;
        this.date = date;
        this.id = new BillHistoryId(bill, body, action);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillHistory that = (BillHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(historyMajor, that.historyMajor) &&
                Objects.equals(body, that.body) &&
                Objects.equals(date, that.date);
    }

    @Override
    public String toString() {
        return "BillHistory{" +
                "id=" + id +
                ", bill=" + bill.getBillId() +
                ", historyMajor=" + historyMajor +
                ", body=" + body +
                ", date=" + date +
                '}';
    }
}
