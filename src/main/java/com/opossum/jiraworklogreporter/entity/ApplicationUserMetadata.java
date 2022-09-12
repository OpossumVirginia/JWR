package com.opossum.jiraworklogreporter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "CWD_USER")
public class ApplicationUserMetadata {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name= "DIRECTORY_ID")
    private double directoryId;

    @Column(name= "USER_NAME")
    private String userName;

    @Column(name= "LOWER_USER_NAME")
    private String lowerUserName;

    @Column(name= "ACTIVE")
    private Integer active;

    @Column(name= "CREATED_DATE")
    private Timestamp createdDate;

    @Column(name= "UPDATED_DATE")
    private Timestamp updatedDate;

    @Column(name= "FIRST_NAME")
    private String firstName;

    @Column(name= "LOWER_FIRST_NAME")
    private String lowerFirstName;

    @Column(name= "LAST_NAME")
    private String lastName;

    @Column(name= "LOWER_LAST_NAME")
    private String lowerLastName;

    @Column(name= "DISPLAY_NAME")
    private String displayName;

    @Column(name= "LOWER_DISPLAY_NAME")
    private String lowerDisplayName;

    @Column(name= "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name= "LOWER_EMAIL_ADDRESS")
    private String lowerEmailAddress;

    @Column(name= "CREDENTIAL")
    private String credential;

    @Column(name= "DELETED_EXTERNALLY")
    private Integer deletedExternally;

    @Column(name= "EXTERNAL_ID")
    private String externalId;


    public ApplicationUserMetadata() {
    }

    public ApplicationUserMetadata(Long id, double directoryId, String userName, String lowerUserName, Integer active, Timestamp createdDate, Timestamp updatedDate, String firstName, String lowerFirstName, String lastName, String lowerLastName, String displayName, String lowerDisplayName, String emailAddress, String lowerEmailAddress, String credential, Integer deletedExternally, String externalId) {
        this.id = id;
        this.directoryId = directoryId;
        this.userName = userName;
        this.lowerUserName = lowerUserName;
        this.active = active;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.firstName = firstName;
        this.lowerFirstName = lowerFirstName;
        this.lastName = lastName;
        this.lowerLastName = lowerLastName;
        this.displayName = displayName;
        this.lowerDisplayName = lowerDisplayName;
        this.emailAddress = emailAddress;
        this.lowerEmailAddress = lowerEmailAddress;
        this.credential = credential;
        this.deletedExternally = deletedExternally;
        this.externalId = externalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(double directoryId) {
        this.directoryId = directoryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLowerUserName() {
        return lowerUserName;
    }

    public void setLowerUserName(String lowerUserName) {
        this.lowerUserName = lowerUserName;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLowerFirstName() {
        return lowerFirstName;
    }

    public void setLowerFirstName(String lowerFirstName) {
        this.lowerFirstName = lowerFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLowerLastName() {
        return lowerLastName;
    }

    public void setLowerLastName(String lowerLastName) {
        this.lowerLastName = lowerLastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLowerDisplayName() {
        return lowerDisplayName;
    }

    public void setLowerDisplayName(String lowerDisplayName) {
        this.lowerDisplayName = lowerDisplayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLowerEmailAddress() {
        return lowerEmailAddress;
    }

    public void setLowerEmailAddress(String lowerEmailAddress) {
        this.lowerEmailAddress = lowerEmailAddress;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Integer getDeletedExternally() {
        return deletedExternally;
    }

    public void setDeletedExternally(Integer deletedExternally) {
        this.deletedExternally = deletedExternally;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "ApplicationUserMetadata{" +
                "id=" + id +
                ", directoryId=" + directoryId +
                ", userName='" + userName + '\'' +
                ", lowerUserName='" + lowerUserName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", firstName='" + firstName + '\'' +
                ", lowerFirstName='" + lowerFirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lowerLastName='" + lowerLastName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", lowerDisplayName='" + lowerDisplayName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", lowerEmailAddress='" + lowerEmailAddress + '\'' +
                ", credential='" + credential + '\'' +
                ", deletedExternally=" + deletedExternally +
                ", externalId='" + externalId + '\'' +
                '}';
    }
}
