package com.example.controller;


import java.lang.reflect.Array;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.exception.AppointmentNotSavedSuccessfully;
import com.example.exception.DoctorNotFoundException;
import com.example.exception.InvalidCrediantials;
import com.example.model.Appointment;
import com.example.model.City;
import com.example.model.Doctor;
import com.example.model.DoctorLogin;
import com.example.model.DoctorName;
import com.example.model.Login;
import com.example.model.Patient;
import com.example.model.PatientLogin;
import com.example.service.AappointmentService;
import com.example.service.AdminService;
import com.example.service.DoctorService;
import com.example.service.HospitalService;
import com.example.service.PatientService;





@Controller
public class MainController {

	@Autowired
	HospitalService hopser;

	@Autowired
	PatientService patser;
	
	@Autowired
	AappointmentService appser;
	
	@Autowired
	AdminService adminser;
	
	@Autowired
	DoctorService doctloginserv;



	//Admin Operations
	@PostMapping("/admincheck")
	public ResponseEntity AdminLogin(@RequestBody Login alogin)  {
		boolean b = adminser.checkAdminCred(alogin);
		if(b) {
		return ResponseEntity.ok("Admin Logged in Successfully");}
		else {
			throw new InvalidCrediantials();
		}
		
	}
	
	@PostMapping("/admincreate")
	public ResponseEntity AdminCreate(@RequestBody Login alogin)  {
		Login b = adminser.createAdmin(alogin);
		
		return ResponseEntity.ok("Admin Created Successfully"+b);
	
		
	}

	
	
	//doctor CURD
	@PostMapping("/doctorreg")		
	public ResponseEntity DoctorRegPage(@RequestHeader("id") int id,@RequestHeader("username") String username,
			@RequestHeader("password") String password,@RequestBody Doctor doctor)
	{	
		Doctor d;
		Login login = new Login(id,username,password);
		boolean b = adminser.checkAdminCred(login);
		if(b) {
			d = hopser.saveDoctor(doctor);}
		else {
			throw new InvalidCrediantials();
		}
		
		
		return ResponseEntity.ok("Doctor has added to DB" +d);
		
		
	}
	
	@GetMapping("/doctorget/{id}")		
	public ResponseEntity DoctorGetPage(@RequestHeader("id") int id,@RequestHeader("username") String username,
			@RequestHeader("password") String password,@PathVariable int did)
	{	
		Doctor d;
		Login login = new Login(id,username,password);
		boolean b = adminser.checkAdminCred(login);
		if(b) {
	
		Optional<Doctor> doctor = hopser.getDoctorById(did);
		if(doctor.isPresent()) {
		return ResponseEntity.ok(doctor.get());
		}
		else {
		throw new DoctorNotFoundException(did);
		}
		}else {
			throw new InvalidCrediantials();
		}
		
	}
	

	@GetMapping("/doctorgetAll")		
	public ResponseEntity DoctorGetPage(@RequestHeader("id") int id,@RequestHeader("username") String username,
			@RequestHeader("password") String password)
	{	
		List<Doctor> doctor;
		Login login = new Login(id,username,password);
		boolean b = adminser.checkAdminCred(login);
		if(b) {
	
		 doctor = hopser.getAllDoctor();
		}else {
			throw new InvalidCrediantials();
		}
		
		return ResponseEntity.ok(doctor);
		
	}
	
	@PutMapping("/doctorupdate")		
	public ResponseEntity DoctorUpdate(@RequestHeader("id") int id,@RequestHeader("username") String username,
			@RequestHeader("password") String password,@RequestBody Doctor doctor)
	{	
		Doctor doc;
	Login login = new Login(id,username,password);
	boolean b = adminser.checkAdminCred(login);
	if(b) {
		doc = hopser.updateby(doctor);}
	else {
		throw new InvalidCrediantials();
	}
		
		return ResponseEntity.ok(doc);
	}
	
	@DeleteMapping("/doctordelete/{did}")		
	public ResponseEntity DoctorDelete(@RequestHeader("id") int id,@RequestHeader("username") String username,
			@RequestHeader("password") String password,@PathVariable int did)
	{	
		Login login = new Login(id,username,password);
	
		boolean b = adminser.checkAdminCred(login);
		if(b) {
		hopser.deletebyId(did);}
		else {
			throw new InvalidCrediantials();
		}
		return ResponseEntity.ok("Data Deleted Successfully for id:"+did);
	}
	
	
	
	//Patient CRUD
	@PostMapping("/patientreg")		
	public ResponseEntity PatientRegPage(@RequestBody Patient patient)
	{	
		Patient pat = patser.savePatient(patient);
		
		return ResponseEntity.ok("Patient has added to DB" +pat);
		
		
	}
	
	//Appointment Book
	@PostMapping("/appointment")
	public ResponseEntity appointmentBook(@RequestHeader("id") int id,@RequestHeader("username") String username,
			@RequestHeader("password") String password,@RequestBody Appointment appoint) {
		
		PatientLogin login = new PatientLogin(id,username,password);
		boolean b = patser.checkPatientCred(login);
		System.out.println(appoint);
		System.out.println(b);
		Appointment appointment = null;
		if(b) {
			appointment = appser.saveAppointment(appoint);
		}else {
			throw new AppointmentNotSavedSuccessfully();
		}
		
		return ResponseEntity.ok("Appointment Booked Succesfully"+appointment);
	}
	
	//doctor CRUD
	@GetMapping("/doctorViewAllAppointments/{did}")
	public ResponseEntity getAllAppointments(@RequestHeader("username") String username,
			@RequestHeader("password") String password,@PathVariable int did) {
		
		DoctorLogin login = new DoctorLogin(did,username,password);
			boolean d = doctloginserv.checkDoctorCred(login);
			List<Appointment> app = null;
			if(d) {
				app = appser.displayAppointment(did);	
			}
			
			return ResponseEntity.ok("The appointment details are:"+app);
	}
	
	

}






















