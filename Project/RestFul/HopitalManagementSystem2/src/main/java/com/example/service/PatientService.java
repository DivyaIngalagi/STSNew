package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Login;
import com.example.model.Patient;
import com.example.model.PatientLogin;

public interface PatientService {
	public Patient savePatient(Patient patient);
	public boolean checkPatientCred(PatientLogin login);
}
