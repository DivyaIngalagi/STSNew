package com.impact.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impact.project.model.Patient;

@Repository
public interface PatientRepo extends CrudRepository<Patient, Integer> {

}
