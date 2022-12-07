package com.impact.project.mapper;

import org.springframework.stereotype.Component;

import com.impact.project.dto.AppointmentOldSlot;
import com.impact.project.model.AppointmentSchedule;

@Component
public class AppointmentScheduleMapper {

    public AppointmentOldSlot mapToAppointmentOldSlot(AppointmentSchedule appSchedule) {

        AppointmentOldSlot appOldSlot = new AppointmentOldSlot();
        appOldSlot.setAppointmentId(appSchedule.getAppointmentId());
        appOldSlot.setDateofappointment(appSchedule.getDateofappointment());

        appOldSlot.setMeetingdesc(appSchedule.getMeetingdesc());
        appOldSlot.setMeetingtitle(appSchedule.getMeetingtitle());
        appOldSlot.setSlot(appSchedule.getSlot());
        appOldSlot.setPhysician(appSchedule.getPhysician());
        appOldSlot.setPatient(appSchedule.getPatient());
        appOldSlot.setLast_updated_by(appSchedule.getLast_updated_by());
        appOldSlot.setLast_update_on(appSchedule.getLast_update_on());
        appOldSlot.setCreated_by(appSchedule.getCreated_by());
        appOldSlot.setCreated_on(appSchedule.getCreated_on());
        return appOldSlot;
    }
}
