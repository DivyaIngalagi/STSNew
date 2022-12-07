package com.impact.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.project.dto.AppointmentDto;
import com.impact.project.dto.PatientVisitDetailsDto;
import com.impact.project.model.Allergies;
import com.impact.project.model.Allergy;
import com.impact.project.model.Patient;
import com.impact.project.service.AllergyService;
import com.impact.project.service.PatientService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AllergyService allergyService;

    @PostMapping("/save")
    public String savePatient(@RequestBody Patient patient) {

        Patient patient1 = patientService.checkUserIdPresent(patient.getUserId());
        if (patient1 != null) {
            patient.setPatientId(patient1.getPatientId());

        }
        if (patient.getAllergies() != null) {
            Set<Allergies> all = patient.getAllergies();
            for (Allergies allergies : all) {
                if (allergies.getAllergiesId() == "") {

                    patient.setAllergies(null);
                }
            }
        }

        Date date = new Date();

        patient.setActive(true);
        patient.setDeleted(false);
        patient.setCreatedBy(patient.getPatientFirstName());
        patient.setCreatedOn(date);
        patient.setLastUpdatedBy(patient.getPatientFirstName());
        patient.setLastUpadteOn(date);
        patientService.savePatient(patient);
        if (patient1 != null) {
            return "Patient was already Present. Updated the details";
        }
        return "Patient saved successfully";
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        List<Patient> List = patientService.getAllPatient();
        return List;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        System.out.println("_____________****************************_______________");
        System.out.println("Call is id" + id);
        Patient patientDetail = patientService.getPatientById(id);
        System.out.println("Patient is" + patientDetail.toString());
        return patientDetail;
    }

    @GetMapping("/allergies")
    public List<Allergy> getAllAllergydetailsList() {
        List<Allergy> List = allergyService.getAllergybyId();
        return List;
    }

    @PutMapping("/update")
    public Patient updatePatient(@RequestBody Patient patient) {
        Patient patientDemoDetail = patientService.savePatient(patient);

        return patientDemoDetail;
    }

    @GetMapping("/appointment")
    public List<AppointmentDto> getUpcomgAppointments() {
        List<AppointmentDto> applist = null;

        // Here call to rest api from scheduling Service

        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setPatientName("Sheetal");
        appointmentDto.setPhysicianName("Dr.Sable");
        appointmentDto.setDateofappointment("2022-07-07");
        appointmentDto.setStart_time("3pm");
        appointmentDto.setEnd_time("4pm");
        applist.add(appointmentDto);
        return applist;
    }

    @GetMapping("/visitdetails/{id}")
    public List<PatientVisitDetailsDto> getPatientVisitDetails(@PathVariable int id) {

        List<PatientVisitDetailsDto> applist = new ArrayList<>();

        // Here call to rest api from Patient Visit

        PatientVisitDetailsDto visit = new PatientVisitDetailsDto();
        visit.setAppid(1);
        visit.setAppname("Checkup");
        visit.setDate("2022-07-08");
        visit.setTime("7pm to 8pm");
        visit.setHeight(140);
        visit.setWeight(70);
        visit.setBodyTemperature(70);
        visit.setRespirationRate(110);
        visit.setProcedureName("Surgery");
        visit.setProcedureCode("A111");
        visit.setDiagnosisNode("Dia333");
        visit.setDiagnosisName("Allergy");
        visit.setDescription("Minor Allergy");

        PatientVisitDetailsDto visit1 = new PatientVisitDetailsDto();
        visit1.setAppid(2);
        visit1.setAppname("Surgery");
        visit1.setDate("2022-07-07");
        visit1.setTime("1pm to 3pm");
        visit1.setHeight(110);
        visit1.setWeight(30);
        visit1.setBodyTemperature(90);
        visit1.setRespirationRate(100);
        visit1.setProcedureName("Dental");
        visit1.setProcedureCode("A555");
        visit1.setDiagnosisNode("Dia777");
        visit1.setDiagnosisName("Allergy Of Animal");
        visit1.setDescription("Operation Needed");

        applist.add(visit);

        applist.add(visit1);
        return applist;
    }
}
