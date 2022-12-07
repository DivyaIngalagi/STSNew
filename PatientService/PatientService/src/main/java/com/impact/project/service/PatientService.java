package com.impact.project.service;

import java.util.List;

import com.impact.project.model.Patient;

public interface PatientService {
    public Patient savePatient(Patient patient);

    public List<Patient> getAllPatient();

    public Patient getPatientById(int id);

    public Patient checkUserIdPresent(int userid);

}
