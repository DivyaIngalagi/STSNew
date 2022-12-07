package com.impact.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AppointmentHistory")
public class AppointmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentHistoryId;

    private String reason;

    private String TimeOfModification;

    private int userID;

    private int appointmentId;
}
