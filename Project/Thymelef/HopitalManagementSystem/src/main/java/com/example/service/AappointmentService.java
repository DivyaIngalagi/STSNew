package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;

public interface AappointmentService {
	public boolean saveAppointment(Appointment appointment);
}
