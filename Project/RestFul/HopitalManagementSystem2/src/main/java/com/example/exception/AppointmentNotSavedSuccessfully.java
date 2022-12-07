package com.example.exception;

public class AppointmentNotSavedSuccessfully extends RuntimeException {

	public AppointmentNotSavedSuccessfully() {
		super("Appointment not Booked.Sorry For Inconvenience Try Again!!!");
		// TODO Auto-generated constructor stub
	}

	public AppointmentNotSavedSuccessfully(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
