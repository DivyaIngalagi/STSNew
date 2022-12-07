package com.spring.exection;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomerGlobalHandlerException {

	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> customerNotFoundException(CustomerNotFoundException custException,WebRequest request)
	{
		ErrorMessages error=new ErrorMessages(new Date(),custException.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> methodHandlesGlobalException(Exception ex,WebRequest request)
	{
		ErrorMessages error=new ErrorMessages(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
