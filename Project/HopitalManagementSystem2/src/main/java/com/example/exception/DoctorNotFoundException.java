package com.example.exception;

public class DoctorNotFoundException extends RuntimeException {

	public DoctorNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorNotFoundException(int arg0) {
		super("Doctor Not Found"+arg0);
		// TODO Auto-generated constructor stub
	}

	
}
