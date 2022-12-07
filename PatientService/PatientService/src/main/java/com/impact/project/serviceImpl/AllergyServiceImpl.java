package com.impact.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.project.model.Allergy;
import com.impact.project.repository.AllergyRepo;
import com.impact.project.service.AllergyService;

@Service
public class AllergyServiceImpl implements AllergyService {

    @Autowired
    private AllergyRepo arepo;

    @Override
    public List<Allergy> getAllergybyId() {

        List<Allergy> allergyList = (List<Allergy>) arepo.findAll();

        return allergyList;
    }

}
