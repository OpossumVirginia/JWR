package com.opossum.jiraworklogreporter.dto;

import java.sql.Timestamp;

public class WorklogReportingDTO {

    private String author;

    private double hoursWorked;

    private String ticket;

    private Timestamp startdate;
    private Timestamp created;

    private String ticketSummary;
    private String ticketURL;
    private String workComment;

    protected WorklogReportingDTO() {}

    public WorklogReportingDTO(String author, Double hoursWorked, String ticket, Timestamp startdate, Timestamp created, String ticketSummary, String workComment, String ticketURL) {
        this.author = author;
        this.hoursWorked = hoursWorked;
        this.ticket = ticket;
        this.startdate = startdate;
        this.created = created;
        this.ticketSummary = ticketSummary;
        this.workComment = workComment;
        this.ticketURL = ticketURL;
    }
    public String getTicketURL() {
        return ticketURL;
    }

    public void setTicketURL(String ticketURL) {
        this.ticketURL = ticketURL;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Timestamp getCreated() {
        return created;
    }
    public Timestamp getStartdate() {
        return startdate;
    }

    public String getTicket() {
        return ticket;
    }

    public String getAuthor() {
        return author;
    }

    public String getWorkComment() {
        return workComment;
    }

    public String getTicketSummary() {
        return ticketSummary;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setWorkComment(String workComment) {
        this.workComment = workComment;
    }

    public void setTicketSummary(String ticketSummary) {
        this.ticketSummary = ticketSummary;
    }

    @Override
    public String toString() {
        return String.format("WorklogEntry - Author: %s, Worked on: %s,Created: %s, Hours worked: %s, Ticket: %s, Ticket summary: %s, Worklog comment: %s. "
                , author, startdate, created, hoursWorked, ticket, ticketSummary, workComment == null ? "" : workComment);
    }
}
