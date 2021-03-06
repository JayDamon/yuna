package com.protean.legislativetracker.yuna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "committee")
public class Committee {

    @Id
    @Column(name = "committee_id", nullable = false)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "committee_body_id", nullable = false)
    private Body body;
    @Column(name = "committee_name", nullable = false)
    private String name;

    public Committee() {
    }

    public Committee(Integer id, Body body, String name, Bill bill) {
        setId(id);
        this.body = body;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                Objects.equals(body, committee.body) &&
                Objects.equals(name, committee.name);
    }

    @Override
    public String toString() {
        return "Committee{" +
                "id=" + id +
                ", body=" + body +
                ", name='" + name + '\'' +
                '}';
    }
}
