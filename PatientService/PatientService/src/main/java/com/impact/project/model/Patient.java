package com.impact.project.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "FieldHandler" })
@Table(name = "PatientTable")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private String patientFirstName;

    private String patientLastName;

    private Date dateOfBirth;

    private String gender;

    private String race;

    private String ethnicity;

    private String languages;

    private String email;

    private String address;

    private long contactNumber;

    private boolean isActive;

    private boolean isDeleted;

    private String lastUpdatedBy;

    private Date lastUpadteOn;

    private String createdBy;

    private Date createdOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergencyContactInfoId", referencedColumnName = "id")
    private EmergencyContactInfo emergencyContactInfoId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PatientAllergies", joinColumns = @JoinColumn(name = "patientId"), inverseJoinColumns = @JoinColumn(name = "allergiesId"))
    private Set<Allergies> allergies;

    private int userId;

    public EmergencyContactInfo getEmergencyContactInfoId() {
        return emergencyContactInfoId;
    }

    public void setEmergencyContactInfoId(EmergencyContactInfo emergencyContactInfoId) {
        this.emergencyContactInfoId = emergencyContactInfoId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Set<Allergies> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<Allergies> allergies) {
        this.allergies = allergies;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpadteOn() {
        return lastUpadteOn;
    }

    public void setLastUpadteOn(Date lastUpadteOn) {
        this.lastUpadteOn = lastUpadteOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName
                + ", patientLastName=" + patientLastName + ", dateOfBirth=" + dateOfBirth + ", gender="
                + gender + ", race=" + race + ", ethnicity=" + ethnicity + ", languages=" + languages
                + ", email=" + email + ", address=" + address + ", contactNumber=" + contactNumber
                + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", lastUpdatedBy=" + lastUpdatedBy
                + ", lastUpadteOn=" + lastUpadteOn + ", createdBy=" + createdBy + ", createdOn=" + createdOn
                + ", emergencyContactInfoId=" + emergencyContactInfoId + ", allergies=" + allergies
                + ", userId=" + userId + "]";
    }

}
