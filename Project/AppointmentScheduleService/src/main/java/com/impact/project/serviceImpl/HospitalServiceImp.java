package com.impact.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.project.model.Physician;
import com.impact.project.repository.HospitalRepo;
import com.impact.project.service.HospitalService;

@Service
public class HospitalServiceImp implements HospitalService {

    @Autowired(required = true)
    private HospitalRepo userRepo;

    @Override
    public Physician saveDoctor(Physician physician) {
        Physician doc = userRepo.save(physician);
        return doc;
    }

    @Override
    public List<Physician> fetchAllDoctor() {
        List<Physician> phylst = (List<Physician>) userRepo.findAll();
        return phylst;
    }

    @Override
    public Physician getPhysicianByID(int physicianId) {
        Optional<Physician> physician = userRepo.findById(physicianId);
        return physician.get();
    }
}
