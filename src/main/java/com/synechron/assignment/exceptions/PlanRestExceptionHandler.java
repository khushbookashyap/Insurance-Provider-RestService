package com.synechron.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlanRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<PlanErrorResponse> handleCustomException(PlanNotFoundException e1){
		
		PlanErrorResponse error = new PlanErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e1.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<PlanErrorResponse> handleGenericException(RuntimeException e2){
		
		PlanErrorResponse error = new PlanErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("This is a bad request");
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
    public ResponseEntity<PlanErrorResponse> handleIllegalArgumentException(IllegalArgumentException e3){
		
		PlanErrorResponse error = new PlanErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e3.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
}
