package com.opossum.jiraworklogreporter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "APP_USER")
public class ApplicationUser {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name= "USER_KEY")
    private String userkey;
    @Column(name= "LOWER_USER_NAME")
    private String username;

    public ApplicationUser() {
    }

    public ApplicationUser(Long id, String userkey, String username) {
        this.id = id;
        this.userkey = userkey;
        this.username = username;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", userkey='" + userkey + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
