package com.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="appointmenthospital")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;

	
	private Date adate;
	private String atime; 
	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", adate=" + adate + ", atime=" + atime + ", patient=" + patient
				+ ", doctor=" + doctor + "]";
	}
	
	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}
//	@Override
//	public String toString() {
//		return "Appointment [aid=" + aid + ", adate=" + adate + ", atime=" + atime + ", patient=" + patient
//				+ ", doctor=" + doctor + "]";
//	}
		public String getAtime() {
		return atime;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int aid, Date adate, String atime, Patient patient, Doctor doctor) {
		super();
		this.aid = aid;
		this.adate = adate;
		this.atime = atime;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	
}
