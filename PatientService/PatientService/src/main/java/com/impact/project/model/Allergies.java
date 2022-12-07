package com.impact.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AllergiesTable")
public class Allergies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allergiesId;

    private String allergieName;

    private String typeOfAllergie;

    private String isFatal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllergiesId() {
        return allergiesId;
    }

    public void setAllergiesId(String allergiesId) {
        this.allergiesId = allergiesId;
    }

    public String getAllergieName() {
        return allergieName;
    }

    public void setAllergieName(String allergieName) {
        this.allergieName = allergieName;
    }

    public String getTypeOfAllergie() {
        return typeOfAllergie;
    }

    public void setTypeOfAllergie(String typeOfAllergie) {
        this.typeOfAllergie = typeOfAllergie;
    }

    public String getIsFatal() {
        return isFatal;
    }

    public void setIsFatal(String isFatal) {
        this.isFatal = isFatal;
    }

}
