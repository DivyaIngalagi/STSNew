package com.impact.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.project.model.SlotMaster;
import com.impact.project.repository.SlotMasterRepo;
import com.impact.project.service.SlotMasterService;

@Service
public class SlotMasterServiceImpl implements SlotMasterService {

    @Autowired
    private SlotMasterRepo slotMasterRepo;

    @Override
    public List<SlotMaster> getAllSlot() {
        List<SlotMaster> getSlot = (List<SlotMaster>) slotMasterRepo.findAll();
        return getSlot;
    }

}
