package com.protean.legislativetracker.yuna.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.net.URL;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill extends DateAuditable {

    @Id
    @Column(name = "bill_id", nullable = false)
    private Long billId;
    @OneToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
    @OneToOne
    @JoinColumn(name = "session_id", nullable = false)
    private LegislativeSession legislativeSession;
    @OneToOne
    @JoinColumn(name = "body_id", nullable = false)
    private Body body;
    @OneToOne
    @JoinColumn(name = "current_body_id", nullable = false)
    private Body currentBody;
    @OneToOne
    @JoinColumn(name = "bill_type_id", nullable = false)
    private Type type;
    @Column(name = "bill_Number", nullable = false)
    private String billNumber;
    @OneToOne
    @JoinColumn(name = "progress_step_id", nullable = false)
    private Progress status;
    @Column(name = "status_date", nullable = false)
    private Date statusDate;
    @Column(name = "title", nullable = false, columnDefinition = "text")
    private String title;
    @Column(name = "description", nullable = false, columnDefinition = "text")
    private String description;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "bill_committee",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "committee_id"))
    private Set<Committee> committees;
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "pending_committee_id")
    private Committee pendingCommittee;
    @Column(name = "url", nullable = false)
    private URL legiscanUrl;
    @Column(name = "state_link", nullable = false)
    private URL stateUrl;
    @Column(name = "change_hash", nullable = false)
    private String changeHash;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillProgress> progress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillHistory> histories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillSponsor> sponsors;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill", orphanRemoval = true)
    private Set<BillSast> sasts;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "bill_subject",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillText> texts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillVote> votes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillAmendment> amendments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillSupplement> supplements;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillCalendar> calendars;

    public Bill() {
    }

    public Bill(Long billId, State state, LegislativeSession legislativeSession, Body body, Body currentBody, Type type, String billNumber, Progress status, Date statusDate, String title, String description, Set<Committee> committees, Committee pendingCommittee, URL legiscanUrl, URL stateUrl, String changeHash, Set<BillProgress> progress, Set<BillHistory> histories, Set<BillSponsor> sponsors, Set<BillSast> sasts, Set<Subject> subjects, Set<BillText> texts, Set<BillVote> votes, Set<BillAmendment> amendments, Set<BillSupplement> supplements, Set<BillCalendar> calendars) {
        this.billId = billId;
        this.state = state;
        this.legislativeSession = legislativeSession;
        this.body = body;
        this.currentBody = currentBody;
        this.type = type;
        this.billNumber = billNumber;
        this.status = status;
        this.statusDate = statusDate;
        this.title = title;
        this.description = description;
        this.committees = committees;
        this.pendingCommittee = pendingCommittee;
        this.legiscanUrl = legiscanUrl;
        this.stateUrl = stateUrl;
        this.changeHash = changeHash;
        this.progress = progress;
        this.histories = histories;
        this.sponsors = sponsors;
        this.sasts = sasts;
        this.subjects = subjects;
        this.texts = texts;
        this.votes = votes;
        this.amendments = amendments;
        this.supplements = supplements;
        this.calendars = calendars;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LegislativeSession getLegislativeSession() {
        return legislativeSession;
    }

    public void setLegislativeSession(LegislativeSession legislativeSession) {
        this.legislativeSession = legislativeSession;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Body getCurrentBody() {
        return currentBody;
    }

    public void setCurrentBody(Body currentBody) {
        this.currentBody = currentBody;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Progress getStatus() {
        return status;
    }

    public void setStatus(Progress status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
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

    public Set<Committee> getCommittees() {
        return committees;
    }

    public void setCommittees(Set<Committee> committees) {
        this.committees = committees;
    }

    public Committee getPendingCommittee() {
        return pendingCommittee;
    }

    public void setPendingCommittee(Committee pendingCommittee) {
        this.pendingCommittee = pendingCommittee;
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

    public String getChangeHash() {
        return changeHash;
    }

    public void setChangeHash(String changeHash) {
        this.changeHash = changeHash;
    }

    public Set<BillProgress> getProgress() {
        return progress;
    }

    public void setProgress(Set<BillProgress> progress) {
        this.progress = progress;
    }

    public Set<BillHistory> getHistories() {
        return histories;
    }

    public void setHistories(Set<BillHistory> histories) {
        this.histories = histories;
    }

    public Set<BillSponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(Set<BillSponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public Set<BillSast> getSasts() {
        return sasts;
    }

    public void setSasts(Set<BillSast> sasts) {
        this.sasts = sasts;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<BillText> getTexts() {
        return texts;
    }

    public void setTexts(Set<BillText> texts) {
        this.texts = texts;
    }

    public Set<BillVote> getVotes() {
        return votes;
    }

    public void setVotes(Set<BillVote> votes) {
        this.votes = votes;
    }

    public Set<BillAmendment> getAmendments() {
        return amendments;
    }

    public void setAmendments(Set<BillAmendment> amendments) {
        this.amendments = amendments;
    }

    public Set<BillSupplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(Set<BillSupplement> supplements) {
        this.supplements = supplements;
    }

    public Set<BillCalendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(Set<BillCalendar> calendars) {
        this.calendars = calendars;
    }

    public Bill getBill() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(billId, bill.billId) &&
                Objects.equals(state, bill.state) &&
                Objects.equals(legislativeSession, bill.legislativeSession) &&
                Objects.equals(body, bill.body) &&
                Objects.equals(currentBody, bill.currentBody) &&
                Objects.equals(type, bill.type) &&
                Objects.equals(billNumber, bill.billNumber) &&
                Objects.equals(status, bill.status) &&
                Objects.equals(statusDate, bill.statusDate) &&
                Objects.equals(title, bill.title) &&
                Objects.equals(description, bill.description) &&
                Objects.equals(committees, bill.committees) &&
                Objects.equals(pendingCommittee, bill.pendingCommittee) &&
                Objects.equals(legiscanUrl, bill.legiscanUrl) &&
                Objects.equals(stateUrl, bill.stateUrl) &&
                Objects.equals(changeHash, bill.changeHash) &&
                Objects.equals(progress, bill.progress) &&
                Objects.equals(histories, bill.histories) &&
                Objects.equals(sponsors, bill.sponsors) &&
                Objects.equals(sasts, bill.sasts) &&
                Objects.equals(subjects, bill.subjects) &&
                Objects.equals(texts, bill.texts) &&
                Objects.equals(votes, bill.votes) &&
                Objects.equals(amendments, bill.amendments) &&
                Objects.equals(supplements, bill.supplements) &&
                Objects.equals(calendars, bill.calendars);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", state=" + state +
                ", legislativeSession=" + legislativeSession +
                ", body=" + body +
                ", currentBody=" + currentBody +
                ", type=" + type +
                ", billNumber='" + billNumber + '\'' +
                ", status=" + status +
                ", statusDate=" + statusDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", committees=" + committees +
                ", pendingCommittee=" + pendingCommittee +
                ", legiscanUrl=" + legiscanUrl +
                ", stateUrl=" + stateUrl +
                ", changeHash='" + changeHash + '\'' +
                ", progress=" + progress +
                ", histories=" + histories +
                ", sponsors=" + sponsors +
                ", sasts=" + sasts +
                ", subjects=" + subjects +
                ", texts=" + texts +
                ", votes=" + votes +
                ", amendments=" + amendments +
                ", supplements=" + supplements +
                ", calendars=" + calendars +
                '}';
    }
}
