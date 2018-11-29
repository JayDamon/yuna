package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillVoteDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roll_call_id")
    private BillVote rollCall;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id")
    private Person person;

    public BillVoteDetailId() {
    }

    public BillVoteDetailId(BillVote rollCall, Person person) {
        this.rollCall = rollCall;
        this.person = person;
    }

    public BillVote getRollCall() {
        return rollCall;
    }

    public void setRollCall(BillVote rollCall) {
        this.rollCall = rollCall;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillVoteDetailId that = (BillVoteDetailId) o;
        return Objects.equals(rollCall, that.rollCall) &&
                Objects.equals(person, that.person);
    }

    @Override
    public String toString() {
        return "BillVoteDetailId{" +
                "rollCall=" + rollCall +
                ", person=" + person +
                '}';
    }
}
