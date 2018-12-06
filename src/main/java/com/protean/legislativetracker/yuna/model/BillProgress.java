package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill_progress")
public class BillProgress implements MappedBillId<BillProgressId> {

    @EmbeddedId
    private BillProgressId id = new BillProgressId();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "progress_event_id")
    private Progress progress;
    @Column(name = "progress_date")
    private Date progressDate;

    public BillProgress() {
    }

    public BillProgress(Bill bill, Progress progress, Date progressDate, Integer progressEventId) {
        this.bill = bill;
        this.progress = progress;
        this.progressDate = progressDate;
        this.id = new BillProgressId(bill, progressEventId);
    }

    @Override
    public BillProgressId getId() {
        return id;
    }

    public void setId(BillProgressId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Date getProgressDate() {
        return progressDate;
    }

    public void setProgressDate(Date progressDate) {
        this.progressDate = progressDate;
    }

    @Override
    public String toString() {
        return "BillProgress{" +
                "id=" + id +
                ", bill=" + bill.getBillId() +
                ", progress=" + progress +
                ", progressDate=" + progressDate +
                '}';
    }
}
