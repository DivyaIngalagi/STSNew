package com.impact.project.service;

import java.util.List;

import com.impact.project.dto.AppointmentDto;
import com.impact.project.dto.AppointmentOldSlot;
import com.impact.project.model.AppointmentSchedule;

public interface AppointmentScheduleService {

    AppointmentSchedule createAppointment(AppointmentSchedule createShedule);

    List<AppointmentSchedule> displayAppointment(int doctorId);

    AppointmentSchedule getAppointmentByID(int appointmentId);

    void deleteAppointment(int appointmentId);

    AppointmentOldSlot updateAppointment(AppointmentOldSlot updateSchedule);

    List<AppointmentDto> displayAllAppointment();
}
