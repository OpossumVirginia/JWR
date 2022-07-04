package com.opossum.jiraworklogreporter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "JIRAISSUE")
public class JiraIssue {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String pkey;
    private double project;
    private String reporter;
    private String assignee;
    private double issuetype;
    private String summary;
    private String description;
    private String environment;
    private String priority;
    private String resolution;
    private String issuestatus;
    private Timestamp created;
    private Timestamp updated;
    private Timestamp duedate;
    private Timestamp resolutiondate;
    private Timestamp archivedate;
    private double votes;
    private double watches;
    private double timeoriginalestimate;
    private double timeestimate;
    private double timespent;
    @Column(name="workflow_id")
    private double workflowid;
    private double security;
    private double fixfor;
    private double component;
    private double issuenum;
    private String creator;
    private String archived;
    private String archivedby;

    public JiraIssue() {
    }

    public JiraIssue(Long id, String pkey, double project, String reporter, String assignee, double issuetype, String summary, String description, String environment, String priority, String resolution, String issuestatus, Timestamp created, Timestamp updated, Timestamp duedate, Timestamp resolutiondate, Timestamp archivedate, double votes, double watches, double timeoriginalestimate, double timeestimate, double timespent, double workflowid, double security, double fixfor, double component, double issuenum, String creator, String archived, String archivedby) {
        this.id = id;
        this.pkey = pkey;
        this.project = project;
        this.reporter = reporter;
        this.assignee = assignee;
        this.issuetype = issuetype;
        this.summary = summary;
        this.description = description;
        this.environment = environment;
        this.priority = priority;
        this.resolution = resolution;
        this.issuestatus = issuestatus;
        this.created = created;
        this.updated = updated;
        this.duedate = duedate;
        this.resolutiondate = resolutiondate;
        this.archivedate = archivedate;
        this.votes = votes;
        this.watches = watches;
        this.timeoriginalestimate = timeoriginalestimate;
        this.timeestimate = timeestimate;
        this.timespent = timespent;
        this.workflowid = workflowid;
        this.security = security;
        this.fixfor = fixfor;
        this.component = component;
        this.issuenum = issuenum;
        this.creator = creator;
        this.archived = archived;
        this.archivedby = archivedby;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public double getProject() {
        return project;
    }

    public void setProject(double project) {
        this.project = project;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public double getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(double issuetype) {
        this.issuetype = issuetype;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getIssuestatus() {
        return issuestatus;
    }

    public void setIssuestatus(String issuestatus) {
        this.issuestatus = issuestatus;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Timestamp getDuedate() {
        return duedate;
    }

    public void setDuedate(Timestamp duedate) {
        this.duedate = duedate;
    }

    public Timestamp getResolutiondate() {
        return resolutiondate;
    }

    public void setResolutiondate(Timestamp resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    public Timestamp getArchivedate() {
        return archivedate;
    }

    public void setArchivedate(Timestamp archivedate) {
        this.archivedate = archivedate;
    }

    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }

    public double getWatches() {
        return watches;
    }

    public void setWatches(double watches) {
        this.watches = watches;
    }

    public double getTimeoriginalestimate() {
        return timeoriginalestimate;
    }

    public void setTimeoriginalestimate(double timeoriginalestimate) {
        this.timeoriginalestimate = timeoriginalestimate;
    }

    public double getTimeestimate() {
        return timeestimate;
    }

    public void setTimeestimate(double timeestimate) {
        this.timeestimate = timeestimate;
    }

    public double getTimespent() {
        return timespent;
    }

    public void setTimespent(double timespent) {
        this.timespent = timespent;
    }

    public double getWorkflowid() {
        return workflowid;
    }

    public void setWorkflowid(double workflowid) {
        this.workflowid = workflowid;
    }

    public double getSecurity() {
        return security;
    }

    public void setSecurity(double security) {
        this.security = security;
    }

    public double getFixfor() {
        return fixfor;
    }

    public void setFixfor(double fixfor) {
        this.fixfor = fixfor;
    }

    public double getComponent() {
        return component;
    }

    public void setComponent(double component) {
        this.component = component;
    }

    public double getIssuenum() {
        return issuenum;
    }

    public void setIssuenum(double issuenum) {
        this.issuenum = issuenum;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getArchived() {
        return archived;
    }

    public void setArchived(String archived) {
        this.archived = archived;
    }

    public String getArchivedby() {
        return archivedby;
    }

    public void setArchivedby(String archivedby) {
        this.archivedby = archivedby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
