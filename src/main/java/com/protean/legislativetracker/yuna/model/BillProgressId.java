package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class BillProgressId implements Serializable, BillId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "progress_step")
    private Integer progressEventId;
    @Column(name = "progress_date")
    private Date progressDate;

    public BillProgressId() {
    }

    public BillProgressId(Bill bill, Integer progressEventId, Date progressDate) {
        this.bill = bill;
        this.progressEventId = progressEventId;
        this.progressDate = progressDate;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getProgressEventId() {
        return progressEventId;
    }

    public void setProgressEventId(Integer progressEventId) {
        this.progressEventId = progressEventId;
    }

    public Date getProgressDate() {
        return progressDate;
    }

    public void setProgressDate(Date progressDate) {
        this.progressDate = progressDate;
    }

    @Override
    public String toString() {
        return "BillProgressId{" +
                "bill=" + bill.getBillId() +
                ", progressEventId=" + progressEventId +
                ", progressDate=" + progressDate +
                '}';
    }
}
