package com.impact.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impact.project.model.Physician;

@Repository
public interface HospitalRepo extends CrudRepository<Physician, Integer> {

}
