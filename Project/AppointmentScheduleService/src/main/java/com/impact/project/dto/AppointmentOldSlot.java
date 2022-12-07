package com.impact.project.dto;

import java.time.LocalDate;

import com.impact.project.model.Patient;
import com.impact.project.model.Physician;
import com.impact.project.model.Slot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentOldSlot {

    private int appointmentId;

    private String meetingtitle;

    private String meetingdesc;

    private String dateofappointment;

    private boolean isDeleted;

    private String last_updated_by;

    private LocalDate last_update_on;

    private String created_by;

    private LocalDate created_on;

    private Patient patient;

    private Physician physician;

    private Slot slot;

    private int oldSlotId;
}
