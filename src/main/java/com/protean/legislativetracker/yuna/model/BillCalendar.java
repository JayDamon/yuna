package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bill_calendar")
public class BillCalendar extends DateAuditable implements MappedBillId<BillCalendarId> {

    @EmbeddedId
    private BillCalendarId id = new BillCalendarId();

    @ManyToOne
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    @Column(name = "event_date")
    private Date date;
    @Column(name = "event_time")
    private Time time;
    @Column(name = "event_location")
    private String location;
    @Column(name = "event_desc")
    private String description;

    public BillCalendar() {
    }

    public BillCalendar(Bill bill, EventType eventType, Date date, Time time, String location, String description) {
        this.bill = bill;
        this.eventType = eventType;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.id = new BillCalendarId(bill, String.valueOf(hashCode()));
    }

    @Override
    public BillCalendarId getId() {
        id.setEventHash(String.valueOf(hashCode()));
        return id;
    }

    @Override
    public void setId(BillCalendarId id) {
        id.setEventHash(String.valueOf(hashCode()));
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillCalendar that = (BillCalendar) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(eventType, that.eventType) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(location, that.location) &&
                Objects.equals(description, that.description);
    }

    @Override
    public String toString() {
        return "BillCalendar{" +
                "id=" + id +
                ", bill=" + bill.getBillId() +
                ", eventType=" + eventType +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
