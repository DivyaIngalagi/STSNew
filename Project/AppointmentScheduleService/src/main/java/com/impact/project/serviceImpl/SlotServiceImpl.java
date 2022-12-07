package com.impact.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.project.model.Slot;
import com.impact.project.repository.SlotRepo;
import com.impact.project.service.SlotService;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepo slotRepo;

    @Override
    public Slot saveSlot(Slot slot) {
        Slot slotSave = slotRepo.save(slot);
        return slotSave;
    }

}
