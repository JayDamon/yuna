package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bill_vote")
public class BillVote extends DateAuditable implements MappedBill {
    @Id
    @Column(name = "roll_call_id")
    private Long voteId;
    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @OneToOne
    @JoinColumn(name = "roll_call_body_id")
    private Body body;
    @Column(name = "roll_call_desc")
    private Date date;
    @Column(name = "description")
    private String description;
    @Column(name = "yea")
    private Integer yea;
    @Column(name = "nay")
    private Integer nay;
    @Column(name = "nv")
    private Integer nv;
    @Column(name = "absent")
    private Integer absent;
    @Column(name = "total")
    private Integer total;
    @Column(name = "passed")
    private Boolean passed;
    @Column(name = "legiscan_url")
    private URL legiscanUrl;
    @Column(name = "state_url")
    private URL stateUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rollCall")
    private Set<BillVoteDetail> details;

    public BillVote() {
    }

    public BillVote(Long voteId, Bill bill, Body body, Date date, Integer yea, Integer nay, Integer nv, Integer absent, Integer total, Boolean passed, URL legiscanUrl, URL stateUrl, Set<BillVoteDetail> details) {
        this.voteId = voteId;
        this.bill = bill;
        this.body = body;
        this.date = date;
        this.yea = yea;
        this.nay = nay;
        this.nv = nv;
        this.absent = absent;
        this.total = total;
        this.passed = passed;
        this.legiscanUrl = legiscanUrl;
        this.stateUrl = stateUrl;
        this.details = details;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public void setBill(Bill bill) {
        this.bill = bill;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYea() {
        return yea;
    }

    public void setYea(Integer yea) {
        this.yea = yea;
    }

    public Integer getNay() {
        return nay;
    }

    public void setNay(Integer nay) {
        this.nay = nay;
    }

    public Integer getNv() {
        return nv;
    }

    public void setNv(Integer nv) {
        this.nv = nv;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
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

    public Set<BillVoteDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<BillVoteDetail> details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillVote billVote = (BillVote) o;
        return Objects.equals(voteId, billVote.voteId) &&
                Objects.equals(bill, billVote.bill) &&
                Objects.equals(body, billVote.body) &&
                Objects.equals(date, billVote.date) &&
                Objects.equals(description, billVote.description) &&
                Objects.equals(yea, billVote.yea) &&
                Objects.equals(nay, billVote.nay) &&
                Objects.equals(nv, billVote.nv) &&
                Objects.equals(absent, billVote.absent) &&
                Objects.equals(total, billVote.total) &&
                Objects.equals(passed, billVote.passed) &&
                Objects.equals(legiscanUrl, billVote.legiscanUrl) &&
                Objects.equals(stateUrl, billVote.stateUrl) &&
                Objects.equals(details, billVote.details);
    }

    @Override
    public String toString() {
        return "BillVote{" +
                "voteId=" + voteId +
                ", bill=" + bill.getBillId() +
                ", body=" + body +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", yea=" + yea +
                ", nay=" + nay +
                ", nv=" + nv +
                ", absent=" + absent +
                ", total=" + total +
                ", passed=" + passed +
                ", legiscanUrl=" + legiscanUrl +
                ", stateUrl=" + stateUrl +
                ", details=" + details +
                '}';
    }
}
