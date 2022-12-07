package com.impact.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impact.project.model.Slot;

@Repository
public interface SlotRepo extends CrudRepository<Slot, Integer> {

}
