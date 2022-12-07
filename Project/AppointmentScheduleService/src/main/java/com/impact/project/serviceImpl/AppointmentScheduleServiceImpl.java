package com.impact.project.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.project.dto.AppointmentDto;
import com.impact.project.dto.AppointmentOldSlot;
import com.impact.project.mapper.AppointmentScheduleMapper;
import com.impact.project.model.AppointmentSchedule;
import com.impact.project.model.Patient;
import com.impact.project.model.Physician;
import com.impact.project.model.Slot;
import com.impact.project.model.SlotMaster;
import com.impact.project.repository.AppointmentScheduleRepo;
import com.impact.project.repository.HospitalRepo;
import com.impact.project.repository.PatientRepo;
import com.impact.project.repository.SlotMasterRepo;
import com.impact.project.repository.SlotRepo;
import com.impact.project.service.AppointmentScheduleService;
import com.impact.project.service.SlotService;

@Service
public class AppointmentScheduleServiceImpl implements AppointmentScheduleService {

    @Autowired
    private AppointmentScheduleRepo appointRepo;

    @Autowired
    private SlotService slotService;

    @Autowired
    private SlotMasterRepo slotMasterRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private HospitalRepo physicianRepo;

    @Autowired
    private SlotRepo slotRepo;

    @Autowired
    private AppointmentScheduleMapper appointMapper;

    @Override
    @org.springframework.transaction.annotation.Transactional
    public AppointmentSchedule createAppointment(AppointmentSchedule appointmentScheduleCreate) {
        LocalDate todayDate = LocalDate.now();
        appointmentScheduleCreate.setDeleted(false);
        appointmentScheduleCreate.setLast_updated_by("Admin");
        appointmentScheduleCreate.setLast_update_on(todayDate);
        appointmentScheduleCreate.setCreated_by("Admin");
        appointmentScheduleCreate.setCreated_on(todayDate);
        appointmentScheduleCreate.setDateofappointment(appointmentScheduleCreate.getDateofappointment());
        Optional<SlotMaster> slotMaster = slotMasterRepo
                .findById(appointmentScheduleCreate.getSlot().getSlot_id());

        Slot slot = new Slot();
        slot.setStart_time(slotMaster.get().getSlotstart_time());
        slot.setEnd_time(slotMaster.get().getSlotend_time());
        slot.setSlotname(slotMaster.get().getSlotname());
        slot.setDateOfAppointment(appointmentScheduleCreate.getDateofappointment());
        slot.setDeleted(false);
        slot.setStatus("Aavailable");
        slot.setLast_updated_by("Admin");
        slot.setLast_update_on(todayDate);
        slot.setCreated_by("Admin");
        slot.setCreated_on(todayDate);
        slotService.saveSlot(slot);
        return appointRepo.save(appointmentScheduleCreate);
    }

    @Override
    public List<AppointmentSchedule> displayAppointment(int doctorId) {
        List<AppointmentSchedule> app = appointRepo.getAllAppointmentRealtedToDoctor(doctorId);
        return app;

    }

    @Override
    public AppointmentSchedule getAppointmentByID(int aID) {
        Optional<AppointmentSchedule> appScheduleGet = appointRepo.findById(aID);
        return appScheduleGet.get();
    }

    @Override
    public void deleteAppointment(int appointmentId) {
        Optional<AppointmentSchedule> appointScheduleDelete = appointRepo.findById(appointmentId);
        appointScheduleDelete.get().setDeleted(true);
        appointRepo.save(appointScheduleDelete.get());

    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public AppointmentOldSlot updateAppointment(AppointmentOldSlot appointmentSchedule) {

        Optional<AppointmentSchedule> appoint = appointRepo.findById(appointmentSchedule.getAppointmentId());

        AppointmentSchedule appointSchdUpdate = appoint.get();
        LocalDate todayDate = LocalDate.now();
        Optional<Slot> prevSlot = slotRepo.findById(appointmentSchedule.getOldSlotId());
        prevSlot.get().setDeleted(true);
        slotRepo.save(prevSlot.get());
        Optional<SlotMaster> slotMaster = slotMasterRepo.findById(appointmentSchedule.getSlot().getSlot_id());

        Slot slot = new Slot();
        slot.setStart_time(slotMaster.get().getSlotstart_time());
        slot.setEnd_time(slotMaster.get().getSlotend_time());
        slot.setSlotname(slotMaster.get().getSlotname());
        slot.setDateOfAppointment(appointmentSchedule.getDateofappointment());
        slot.setDeleted(false);
        slot.setStatus("Aavailable");
        slot.setLast_updated_by("Admin");
        slot.setLast_update_on(todayDate);
        slot.setCreated_by("Admin");
        slot.setCreated_on(todayDate);
        Slot savedSlot = slotService.saveSlot(slot);

        appointSchdUpdate.setAppointmentId(appointmentSchedule.getAppointmentId());
        String dateStr = appointmentSchedule.getDateofappointment();
        String actualDate = dateStr.substring(0, 9);
        appointSchdUpdate.setDateofappointment(actualDate);
        appointSchdUpdate.setMeetingdesc(appointmentSchedule.getMeetingdesc());
        appointSchdUpdate.setMeetingtitle(appointmentSchedule.getMeetingtitle());
        appointSchdUpdate.setSlot(savedSlot);
        appointSchdUpdate.setPhysician(appointmentSchedule.getPhysician());
        appointSchdUpdate.setPatient(appointmentSchedule.getPatient());
        appointSchdUpdate.setLast_updated_by("Admin");
        appointSchdUpdate.setLast_update_on(todayDate);
        appointSchdUpdate.setCreated_by("Admin");
        appointSchdUpdate.setCreated_on(todayDate);

        return appointMapper.mapToAppointmentOldSlot(appointRepo.save(appointSchdUpdate));
    }

    @Override
    public List<AppointmentDto> displayAllAppointment() {
        List<AppointmentDto> allSchedulesDetails = new ArrayList<>();
        List<AppointmentSchedule> allAppointments = appointRepo.findAll();
        for (AppointmentSchedule appointmentSchedule : allAppointments) {

            Optional<Patient> patientObj = patientRepo.findById(appointmentSchedule.getPatient().getPatid());
            AppointmentDto appDto = new AppointmentDto();
            appDto.setPatientName(patientObj.get().getName());
            Optional<Physician> physicianObj = physicianRepo
                    .findById(appointmentSchedule.getPhysician().getDocid());
            appDto.setPhysicianName(physicianObj.get().getName());
            Optional<Slot> slotObj = slotRepo.findById(appointmentSchedule.getSlot().getSlot_id());
            appDto.setStart_time(slotObj.get().getStart_time());
            appDto.setEnd_time(slotObj.get().getEnd_time());
            appDto.setSlotname(slotObj.get().getSlotname());
            appDto.setDateofappointment(appointmentSchedule.getDateofappointment());
            appDto.setAppointmentId(appointmentSchedule.getAppointmentId());
            allSchedulesDetails.add(appDto);
        }
        return allSchedulesDetails;
    }

}
