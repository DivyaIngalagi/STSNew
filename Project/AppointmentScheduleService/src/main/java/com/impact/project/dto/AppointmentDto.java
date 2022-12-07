package com.impact.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private String physicianName;

    private String patientName;

    private int appointmentId;

    private String dateofappointment;

    private int start_time;

    private int end_time;

    private String slotname;
}
