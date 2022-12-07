package com.example.dao;

import java.lang.annotation.Native;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;

@Repository		
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	@Transactional
	@Modifying
	@Query(value="select * from appointmentschedule.appointment a , appointmentschedule.doctorhospital d where a.doctor_id=:x and",nativeQuery=true)
	public List<Appointment> getAllAppointmentRealtedToDoctor(@Param(value="x") int doctorId);
	
	
}
