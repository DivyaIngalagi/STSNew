package com.training.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.app.model.Patient;
import com.training.app.model.Physician;
import com.training.app.repository.PatientRepository;
import com.training.app.repository.PhysicianRepository;

@RestController
@RequestMapping("/api/v1")
public class AppController {
	
	@Autowired
	private PhysicianRepository physicianRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/physicians")
	public ResponseEntity<List<Physician>> getAllPhysicianDetails() {
		return ResponseEntity.ok(physicianRepository.findAll());
	}
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatientDetails() {
		return ResponseEntity.ok(patientRepository.findAll());
	}	
	
   @Secured("ROLE_admin")
  @PreAuthorize("hasRole('ROLE_admin') or #id == #jwt.subject")
  @DeleteMapping("/patients/{id}")  
     
   public ResponseEntity<?> deletePatient(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
   patientRepository.deletePatient(id);
   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }	
    
//   
//   @PostAuthorize("hasRole('ROLE_admin') or returnObject.id == #jwt.subject")
//   @GetMapping("/patients/{id}")  
//   public Patient getPatientDetails(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
//	   	Patient patient = patientRepository.findById(id);
//	   	return patient;
//   }   
}













