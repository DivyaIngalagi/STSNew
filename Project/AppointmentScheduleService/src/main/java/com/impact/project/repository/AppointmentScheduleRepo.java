package com.impact.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.impact.project.model.AppointmentSchedule;

@Repository
public interface AppointmentScheduleRepo extends JpaRepository<AppointmentSchedule, Integer> {

    @Transactional
    @Modifying
    @Query(value = "select * from appointmentschedule.appointment a , appointmentschedule.doctorhospital d where a.doctor_id=:x and a.is_deleted=false", nativeQuery = true)
    public List<AppointmentSchedule> getAllAppointmentRealtedToDoctor(@Param(value = "x") int id);

}
