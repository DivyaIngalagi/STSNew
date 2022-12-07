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
@Table(name = "slotmaster")
public class SlotMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotmaster_id;

    private int slotstart_time;

    private int slotend_time;

    private String slotname;
}
