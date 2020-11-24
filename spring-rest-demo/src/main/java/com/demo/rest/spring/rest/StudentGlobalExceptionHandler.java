package com.demo.rest.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentGlobalExceptionHandler {

	//add exception handling code here
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException excep)
	{
		//create a StudentErrorResponse	
		StudentErrorResponse error=new StudentErrorResponse();
		//return ResponseEntity
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(excep.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return ResponseEntity

		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	//add another exception handler to catch any exception (catch all)
	//handle generic Exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception excep)
	{
		//create a StudentErrorResponse	
		StudentErrorResponse error=new StudentErrorResponse();
		//return ResponseEntity
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(excep.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return ResponseEntity

		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

	
}
