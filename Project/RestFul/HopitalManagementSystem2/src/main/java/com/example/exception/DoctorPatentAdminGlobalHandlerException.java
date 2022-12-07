package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class DoctorPatentAdminGlobalHandlerException {

	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<?> doctorNotFoundException(DoctorNotFoundException doctException,WebRequest request)
	{
		ErrorMessages error=new ErrorMessages(new Date(),doctException.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> methodHandlesGlobalException(Exception ex,WebRequest request)
	{
		ErrorMessages error=new ErrorMessages(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
