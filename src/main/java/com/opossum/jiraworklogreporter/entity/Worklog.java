package com.opossum.jiraworklogreporter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;


@Entity
public class Worklog {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private int issueid;
    private String author;
    private String grouplevel;
    private String rolelevel;
    private String updateauthor;
    private double timeworked;
    private Timestamp startdate;
    private Timestamp created;
    private Timestamp updated;
    private String worklogbody;

    public Worklog(Long id, int issueid, String author, String grouplevel, String rolelevel, String updateauthor, double timeworked,  Timestamp startdate, Timestamp created, Timestamp updated,  String worklogbody) {
        this.id = id;
        this.issueid = issueid;
        this.author = author;
        this.grouplevel = grouplevel;
        this.rolelevel = rolelevel;
        this.updateauthor = updateauthor;
        this.timeworked = timeworked;
        this.startdate = startdate;
        this.created = created;
        this.updated = updated;
        this.worklogbody = worklogbody;
    }

    public int getIssueid() {
        return issueid;
    }

    public void setIssueid(int issueid) {
        this.issueid = issueid;
    }

    public String getGrouplevel() {
        return grouplevel;
    }

    public void setGrouplevel(String grouplevel) {
        this.grouplevel = grouplevel;
    }

    public String getRolelevel() {
        return rolelevel;
    }

    public void setRolelevel(String rolelevel) {
        this.rolelevel = rolelevel;
    }

    public String getUpdateauthor() {
        return updateauthor;
    }

    public void setUpdateauthor(String updateauthor) {
        this.updateauthor = updateauthor;
    }

    public double getTimeworked() {
        return timeworked;
    }

    public void setTimeworked(double timeworked) {
        this.timeworked = timeworked;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getWorklogbody() {
        return worklogbody;
    }

    public void setWorklogbody(String workbody) {
        this.worklogbody = workbody;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Worklog() {
    }

    @Override
    public String toString() {
        return "Worklog{" +
                "id=" + id +
                ", issueid=" + issueid +
                ", author='" + author + '\'' +
                ", grouplevel='" + grouplevel + '\'' +
                ", rolelevel='" + rolelevel + '\'' +
                ", updateauthor='" + updateauthor + '\'' +
                ", timeworked=" + timeworked +
                ", startdate=" + startdate +
                ", created=" + created +
                ", updated=" + updated +
                ", worklogbody='" + worklogbody + '\'' +
                '}';
    }
}
