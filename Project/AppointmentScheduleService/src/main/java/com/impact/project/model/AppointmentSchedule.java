package com.impact.project.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Appointment")
public class AppointmentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    private String meetingtitle;

    private String meetingdesc;

    private String dateofappointment;

    private boolean isDeleted;

    private String last_updated_by;

    private LocalDate last_update_on;

    private String created_by;

    private LocalDate created_on;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Physician physician;

    @OneToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @Override
    public String toString() {
        return "AppointmentSchedule [appointmentId=" + appointmentId + ", meetingtitle=" + meetingtitle
                + ", meetingdesc=" + meetingdesc + ", dateofappointment=" + dateofappointment + ", isDeleted="
                + isDeleted + ", last_updated_by=" + last_updated_by + ", last_update_on=" + last_update_on
                + ", created_by=" + created_by + ", created_on=" + created_on + ", patient=" + patient
                + ", physician=" + physician + ", slot=" + slot + "]";
    }

}
