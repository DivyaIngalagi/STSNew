package com.impact.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impact.project.model.SlotMaster;

@Repository
public interface SlotMasterRepo extends CrudRepository<SlotMaster, Integer> {

}
