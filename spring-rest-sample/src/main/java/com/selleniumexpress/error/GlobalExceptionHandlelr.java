package com.selleniumexpress.error;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlelr {
	
	
	
	@ExceptionHandler
	public ResponseEntity<CustomError> handleSNF(StudentNotFoundException snf){
		
		CustomError error=new CustomError();
		error.setDate(LocalDateTime.now().toString());	
		error.setMessage(snf.getMessage());
		error.setErrorType(StudentNotFoundException.class.toString());
		
		
		return new ResponseEntity<CustomError>(error,HttpStatus.NOT_FOUND);
		
		
	}
	
	

}
