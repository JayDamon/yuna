package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bill_amendment")
public class BillAmendment extends DateAuditable implements MappedBill {
    @Id
    @Column(name = "amendment_id")
    private Long amendmentId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "local_copy")
    private Integer localCopy;
    @Column(name = "adopted")
    private Integer adopted;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amendment_body_id")
    private Body body;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amendment_mime_id")
    private MimeType mimeType;
    @Column(name = "amendment_date")
    private Date date;
    @Column(name = "amendment_title")
    private String title;
    @Column(name = "amendment_desc")
    private String description;
    @Column(name = "legiscan_url")
    private URL legiscanUrl;
    @Column(name = "state_url")
    private URL stateUrl;

    public BillAmendment() {
    }

    public BillAmendment(Long amendmentId, Bill bill, Integer localCopy, Integer adopted, Body body, MimeType mimeType, Date date, String title, String description, URL legiscanUrl, URL stateUrl) {
        this.amendmentId = amendmentId;
        this.bill = bill;
        this.localCopy = localCopy;
        this.adopted = adopted;
        this.body = body;
        this.mimeType = mimeType;
        this.date = date;
        this.title = title;
        this.description = description;
        this.legiscanUrl = legiscanUrl;
        this.stateUrl = stateUrl;
    }

    public Long getAmendmentId() {
        return amendmentId;
    }

    public void setAmendmentId(Long amendmentId) {
        this.amendmentId = amendmentId;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getLocalCopy() {
        return localCopy;
    }

    public void setLocalCopy(Integer localCopy) {
        this.localCopy = localCopy;
    }

    public Integer getAdopted() {
        return adopted;
    }

    public void setAdopted(Integer adopted) {
        this.adopted = adopted;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getLegiscanUrl() {
        return legiscanUrl;
    }

    public void setLegiscanUrl(URL legiscanUrl) {
        this.legiscanUrl = legiscanUrl;
    }

    public URL getStateUrl() {
        return stateUrl;
    }

    public void setStateUrl(URL stateUrl) {
        this.stateUrl = stateUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillAmendment that = (BillAmendment) o;
        return Objects.equals(amendmentId, that.amendmentId) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(localCopy, that.localCopy) &&
                Objects.equals(adopted, that.adopted) &&
                Objects.equals(body, that.body) &&
                Objects.equals(mimeType, that.mimeType) &&
                Objects.equals(date, that.date) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(legiscanUrl, that.legiscanUrl) &&
                Objects.equals(stateUrl, that.stateUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amendmentId, bill, localCopy, adopted, body, mimeType, date, title, description, legiscanUrl, stateUrl);
    }

    @Override
    public String toString() {
        return "BillAmendment{" +
                "amendmentId=" + amendmentId +
                ", bill=" + bill +
                ", localCopy=" + localCopy +
                ", adopted=" + adopted +
                ", body=" + body +
                ", mimeType=" + mimeType +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", legiscanUrl=" + legiscanUrl +
                ", stateUrl=" + stateUrl +
                '}';
    }
}
