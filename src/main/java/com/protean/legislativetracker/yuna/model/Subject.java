package com.protean.legislativetracker.yuna.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "subject_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "state_id")
    private State state;
    @Column(name = "subject_name")
    private String name;

    public Subject() {
    }

    public Subject(Long id, State state, String name, Set<Bill> bills) {
        this.id = id;
        this.state = state;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
        Subject subject1 = (Subject) o;
        return Objects.equals(id, subject1.id) &&
                Objects.equals(state, subject1.state) &&
                Objects.equals(name, subject1.name);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", state=" + state +
                ", name='" + name + '\'' +
                '}';
    }
}
