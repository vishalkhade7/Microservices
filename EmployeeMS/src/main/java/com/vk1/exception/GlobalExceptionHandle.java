package com.vk1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
    
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> departmentexception(){
		
		return new ResponseEntity<String>("Department Not Found",HttpStatus.BAD_REQUEST);
	}
}
