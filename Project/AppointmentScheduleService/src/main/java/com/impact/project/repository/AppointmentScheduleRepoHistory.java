package com.impact.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.project.model.AppointmentHistory;

@Repository
public interface AppointmentScheduleRepoHistory extends JpaRepository<AppointmentHistory, Integer> {

    // @Transactional
    // @Modifying
    // @Query(value="select * from appointmentschedule.appointment a ,
    // appointmentschedule.doctorhospital d where a.doctor_id=:x and
    // a.is_deleted=false",nativeQuery=true)
    // public List<AppointmentSchedule>
    // getAllAppointmentRealtedToDoctor(@Param(value="x") int id);

}
