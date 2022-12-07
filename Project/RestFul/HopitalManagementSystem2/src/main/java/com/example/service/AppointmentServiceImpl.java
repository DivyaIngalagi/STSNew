package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AppointmentRepository;
import com.example.dao.HospitalRepository;
import com.example.dao.PatientRepository;
import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;

@Service
public class AppointmentServiceImpl implements AappointmentService {

	@Autowired
	AppointmentRepository userrepo;
	
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		Appointment app = userrepo.save(appointment);
		
		return app;
	}

	@Override
	public List<Appointment> displayAppointment(int id) {
		List<Appointment> app = userrepo.getAllAppointmentRealtedToDoctor(id);
		return app;
	}



	
}
