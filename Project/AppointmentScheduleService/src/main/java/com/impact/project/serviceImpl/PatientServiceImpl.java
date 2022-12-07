package com.impact.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.project.model.Patient;
import com.impact.project.repository.PatientRepo;
import com.impact.project.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public Patient savePatient(Patient patient) {
        Patient pats = patientRepo.save(patient);
        return pats;
    }

    @Override
    public List<Patient> getAllPatient() {
        List<Patient> patient = (List<Patient>) patientRepo.findAll();
        return patient;
    }

}
