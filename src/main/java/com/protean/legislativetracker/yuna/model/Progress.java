package com.protean.legislativetracker.yuna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @Column(name = "progress_step_id", nullable = false)
    private Integer progressId;
    @Column(name = "progress_desc", nullable = false)
    private String description;

    public Progress() {
    }

    public Progress(Integer progressId, String description) {
        this.progressId = progressId;
        this.description = description;
    }

    public Integer getProgressId() {
        return progressId;
    }

    public void setProgressId(Integer progressId) {
        this.progressId = progressId;
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
        Progress progress = (Progress) o;
        return Objects.equals(progressId, progress.progressId) &&
                Objects.equals(description, progress.description);
    }

    @Override
    public String toString() {
        return "Progress{" +
                "progressId=" + progressId +
                ", description='" + description + '\'' +
                '}';
    }
}
