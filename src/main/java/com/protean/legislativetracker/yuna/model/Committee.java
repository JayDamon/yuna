package com.protean.legislativetracker.yuna.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "committee")
public class Committee {

    @EmbeddedId
    private BillCommitteeId id;

    @ManyToOne
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "committee_body_id", nullable = false)
    private Body body;
    @Column(name = "committee_name", nullable = false)
    private String name;

    public Committee() {
    }

    public Committee(Bill bill, Body body, String name) {
        this.bill = bill;
        this.body = body;
        this.name = name;
    }

    public BillCommitteeId getId() {
        return id;
    }

    public void setId(BillCommitteeId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Committee committee = (Committee) o;
        return Objects.equals(id, committee.id) &&
                Objects.equals(bill, committee.bill) &&
                Objects.equals(body, committee.body) &&
                Objects.equals(name, committee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bill, body, name);
    }

    @Override
    public String toString() {
        return "Committee{" +
                "id=" + id +
                ", bill=" + bill +
                ", body=" + body +
                ", name='" + name + '\'' +
                '}';
    }
}
