package com.impact.project.model;

import java.time.LocalDate;

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
@Table(name = "slot")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slot_id;

    private boolean isDeleted;

    private int start_time;

    private int end_time;

    private String status;

    private String dateOfAppointment;

    private String last_updated_by;

    private LocalDate last_update_on;

    private String created_by;

    private LocalDate created_on;

    private String slotname;
}
