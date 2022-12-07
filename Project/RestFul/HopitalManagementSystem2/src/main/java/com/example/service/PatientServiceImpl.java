package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.HospitalRepository;
import com.example.dao.PatientLoginRepository;
import com.example.dao.PatientRepository;
import com.example.model.Doctor;
import com.example.model.Login;
import com.example.model.Patient;
import com.example.model.PatientLogin;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientrepo;
	@Autowired
	PatientLoginRepository patientloginrepo;
	
	@Override
	public Patient savePatient(Patient patient) {
		Patient pats = patientrepo.save(patient);
		return pats;
	}
	@Override
	public boolean checkPatientCred(PatientLogin login) {
		Optional<Patient> palogin = patientloginrepo.findById(login.getId());
		
		if(palogin.isPresent()) {
			if(palogin.get().getUsername().equals(login.getLoginUserName()) && 
					palogin.get().getPassword().equals(login.getLoginPassword()))
			{
				return true;
			}
		}
		return false;
	}

	
	
}
