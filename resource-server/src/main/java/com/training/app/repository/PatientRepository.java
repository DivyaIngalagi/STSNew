package com.training.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.app.model.Patient;

@Repository
public class PatientRepository {
	
	private List<Patient> patients;
	
	public PatientRepository() {
		patients = new ArrayList<>();
		patients.add(new Patient("1", "Alex Browning", "alex.browning@2gmail.com", "8877665544", "Mumbai"));
		patients.add(new Patient("2", "Bryan Bash", "bryan.bash@gmail.com", "3344556677", "Pune"));
		patients.add(new Patient("f1ff6152-ecc0-4489-b85c-b7f20d3adf4a", "Bryan Bash", "bryan.bash@gmail.com", "7766554433", "Mumbai"));
	}
	
	public List<Patient> findAll() {
		return patients;	
	}
	
	public Patient findById(String id) {
		for (Patient patient: patients) {
			if (patient.getId().equals(id)) 
				return patient;
		}
		return null;
	}
	
	public void deletePatient(String id) {
		for (Patient patient: patients) {
			if (patient.getId().equals(id)) 
				patients.remove(patient);
		}
	}
}









