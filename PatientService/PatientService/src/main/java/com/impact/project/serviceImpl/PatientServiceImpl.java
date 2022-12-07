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
    PatientRepo patientrepo;

    @Override
    public Patient savePatient(Patient patient) {

        Patient p = patientrepo.save(patient);
        return p;
    }

    @Override
    public List<Patient> getAllPatient() {

        List<Patient> pList = patientrepo.findAll();
        return pList;
    }

    @Override
    public Patient getPatientById(int id) {
        Patient p = patientrepo.getById(id);
        return p;
    }

    @Override
    public Patient checkUserIdPresent(int userid) {
        Patient patientId = patientrepo.isUserIdPresent(userid);
        System.out.println("checkUserIdPresent" + patientId);
        return patientId;
    }

}
