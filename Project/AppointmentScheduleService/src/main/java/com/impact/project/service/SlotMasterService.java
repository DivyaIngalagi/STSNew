package com.impact.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impact.project.model.SlotMaster;

@Service
public interface SlotMasterService {

    public List<SlotMaster> getAllSlot();
}
