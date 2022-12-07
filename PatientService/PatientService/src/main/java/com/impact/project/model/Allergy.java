package com.impact.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allergyId;

    private String allergyType;

    private String allergyName;

    private String allergenSource;

    private String isoFormsOrPartialSequencesOfAllergen;

    private String allergincity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(String allergyId) {
        this.allergyId = allergyId;
    }

    public String getAllergyType() {
        return allergyType;
    }

    public void setAllergyType(String allergyType) {
        this.allergyType = allergyType;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public String getAllergenSource() {
        return allergenSource;
    }

    public void setAllergenSource(String allergenSource) {
        this.allergenSource = allergenSource;
    }

    public String getIsoFormsOrPartialSequencesOfAllergen() {
        return isoFormsOrPartialSequencesOfAllergen;
    }

    public void setIsoFormsOrPartialSequencesOfAllergen(String isoFormsOrPartialSequencesOfAllergen) {
        this.isoFormsOrPartialSequencesOfAllergen = isoFormsOrPartialSequencesOfAllergen;
    }

    public String getAllergincity() {
        return allergincity;
    }

    public void setAllergincity(String allergincity) {
        this.allergincity = allergincity;
    }

}
