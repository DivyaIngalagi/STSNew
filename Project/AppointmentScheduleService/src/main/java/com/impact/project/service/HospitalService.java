package com.impact.project.service;

import java.util.List;

import com.impact.project.model.Physician;

public interface HospitalService {

    public Physician saveDoctor(Physician physician);

    public List<Physician> fetchAllDoctor();

    public Physician getPhysicianByID(int physicianId);
}
