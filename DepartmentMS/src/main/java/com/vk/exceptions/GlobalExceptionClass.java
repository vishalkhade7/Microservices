package com.vk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionClass {
   
	@ExceptionHandler(FirstgreaterThanSecondException.class)
	public ResponseEntity<String> customeException1(String exception){
		
    	return new ResponseEntity<String>("First > second",HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(SecondgreaterThanFirstException.class)
	public ResponseEntity<String> customeException2(String exception){
		
    	return new ResponseEntity<String>("First < second",HttpStatus.BAD_REQUEST);
	}
}
