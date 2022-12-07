package com.impact.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impact.project.model.Allergy;

@Repository
public interface AllergyRepo extends CrudRepository<Allergy, Integer> {

}
