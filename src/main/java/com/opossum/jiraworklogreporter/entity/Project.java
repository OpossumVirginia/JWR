package com.opossum.jiraworklogreporter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String pname;
    private String url;
    private String lead;
    private String description;
    private String pkey;
    private double pcounter;
    private double assigneetype;
    private double avatar;
    private String originalkey;
    private String projecttype;

    public Project() {
    }

    public Project(Long id, String pname, String url, String lead, String description, String pkey, double pcounter, double assigneetype, double avatar, String originalkey, String projecttype) {
        this.id = id;
        this.pname = pname;
        this.url = url;
        this.lead = lead;
        this.description = description;
        this.pkey = pkey;
        this.pcounter = pcounter;
        this.assigneetype = assigneetype;
        this.avatar = avatar;
        this.originalkey = originalkey;
        this.projecttype = projecttype;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public double getPcounter() {
        return pcounter;
    }

    public void setPcounter(double pcounter) {
        this.pcounter = pcounter;
    }

    public double getAssigneetype() {
        return assigneetype;
    }

    public void setAssigneetype(double assigneetype) {
        this.assigneetype = assigneetype;
    }

    public double getAvatar() {
        return avatar;
    }

    public void setAvatar(double avatar) {
        this.avatar = avatar;
    }

    public String getOriginalkey() {
        return originalkey;
    }

    public void setOriginalkey(String originalkey) {
        this.originalkey = originalkey;
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
