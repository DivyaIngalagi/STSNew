package com.impact.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.impact.project.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

    @Query(value = "select * from patientdata.patient_table a  where a.user_id=:x", nativeQuery = true)
    Patient isUserIdPresent(@Param(value = "x") int id);

}
