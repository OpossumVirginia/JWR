package com.opossum.jiraworklogreporter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "CWD_USER")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//TODO: add information about the user from the DB - email to put on CC or so
}
