package com.impact.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.project.dto.AppointmentDto;
import com.impact.project.dto.AppointmentOldSlot;
import com.impact.project.model.AppointmentSchedule;
import com.impact.project.model.Patient;
import com.impact.project.model.Physician;
import com.impact.project.model.SlotMaster;
import com.impact.project.service.AppointmentScheduleService;
import com.impact.project.service.HospitalService;
import com.impact.project.service.PatientService;
import com.impact.project.service.SlotMasterService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/appointmentschedule")
public class AppointmentScheduleController {

    @Autowired
    private AppointmentScheduleService appointService;

    @Autowired
    private SlotMasterService slotMasterService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/add")
    public ResponseEntity saveAppointment(@RequestBody AppointmentSchedule appointschedule) {

        appointService.createAppointment(appointschedule);
        return ResponseEntity.ok("Appointment Saved Successfully:");
    }

    @GetMapping("/appointments/{appointmentId}")
    public ResponseEntity getAppointmentByID(@PathVariable int appointmentId) {

        AppointmentSchedule appSchedGet = appointService.getAppointmentByID(appointmentId);
        return ResponseEntity.ok(appSchedGet);
    }

    @GetMapping("/appointments")
    public ResponseEntity getAllAppointment() {

        List<AppointmentDto> allAppointment = appointService.displayAllAppointment();
        return ResponseEntity.ok(allAppointment);
    }

    @GetMapping("/slots")
    public ResponseEntity getAllSlot() {
        List<SlotMaster> slots = slotMasterService.getAllSlot();
        return ResponseEntity.ok(slots);
    }

    @GetMapping("/view/{doctorId}")
    public ResponseEntity getAppointment(@PathVariable int doctorId) {

        List<AppointmentSchedule> displayappont = appointService.displayAppointment(doctorId);
        return ResponseEntity.ok("The appointnment details are:" + displayappont);
    }

    @DeleteMapping("/delete/{appointmentId}")
    public ResponseEntity deleteAppointment(@PathVariable int appointmentId) {
        appointService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("Appointment Deleted Successfully.");
    }

    @PutMapping("/update")
    public ResponseEntity updateAppointment(@RequestBody AppointmentOldSlot appointSlot) {
        AppointmentOldSlot appschedule = appointService.updateAppointment(appointSlot);
        return ResponseEntity.ok(appschedule);
    }

    @PostMapping("/patient-register")
    public ResponseEntity PatientRegPage(@RequestBody Patient patient) {
        Patient patientNew = patientService.savePatient(patient);

        return ResponseEntity.ok(patientNew);

    }

    @GetMapping("/patients")
    public ResponseEntity PatientFetch() {
        List<Patient> patient = patientService.getAllPatient();

        return ResponseEntity.ok(patient);

    }

    @PostMapping("/doctor-register")
    public ResponseEntity DoctorRegPage(@RequestBody Physician doctor) {
        Physician d = hospitalService.saveDoctor(doctor);

        return ResponseEntity.ok("Doctor has added to DB" + d);

    }

    @GetMapping("/physicians")
    public ResponseEntity doctorFetch() {
        List<Physician> pat = hospitalService.fetchAllDoctor();

        return ResponseEntity.ok(pat);

    }

    @GetMapping("/physician/{physicianId}")
    public ResponseEntity getPhysicianByID(@PathVariable int physicianId) {
        Physician physician = hospitalService.getPhysicianByID(physicianId);

        return ResponseEntity.ok(physician);

    }
}
