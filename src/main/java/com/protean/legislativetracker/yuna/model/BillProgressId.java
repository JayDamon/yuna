package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillProgressId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "progress_step")
    private Integer progressEventId;

    public BillProgressId() {
    }

    public BillProgressId(Bill bill, Integer progressEventId) {
        this.bill = bill;
        this.progressEventId = progressEventId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getProgressEventId() {
        return progressEventId;
    }

    public void setProgressEventId(Integer progressEventId) {
        this.progressEventId = progressEventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillProgressId that = (BillProgressId) o;
        return Objects.equals(bill, that.bill) &&
                Objects.equals(progressEventId, that.progressEventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill, progressEventId);
    }

    @Override
    public String toString() {
        return "BillProgressId{" +
                "bill=" + bill +
                ", progressEventId=" + progressEventId +
                '}';
    }
}
