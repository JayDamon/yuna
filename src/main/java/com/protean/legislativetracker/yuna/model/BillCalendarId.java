package com.protean.legislativetracker.yuna.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillCalendarId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "event_hash")
    private String eventHash;

    public BillCalendarId() {
    }

    public BillCalendarId(Bill bill, String eventHash) {
        this.bill = bill;
        this.eventHash = eventHash;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getEventHash() {
        return eventHash;
    }

    public void setEventHash(String eventHash) {
        this.eventHash = eventHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillCalendarId that = (BillCalendarId) o;
        return Objects.equals(bill, that.bill) &&
                Objects.equals(eventHash, that.eventHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill, eventHash);


   }

    @Override
    public String toString() {
        return "BillCalendarId{" +
                "bill=" + bill +
                ", eventHash='" + eventHash + '\'' +
                '}';
    }
}
