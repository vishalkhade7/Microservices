package com.vk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vk.entities.Department;
import com.vk.exceptions.FirstgreaterThanSecondException;
import com.vk.exceptions.SecondgreaterThanFirstException;
import com.vk.services.DepartmentServiceInterface;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentServiceInterface departmentServiceInterface;

	@PostMapping(value = "/department")
	public ResponseEntity<Department> getDepartment(@RequestBody Department department) {
		System.out.println("department: " + department);
		return new ResponseEntity<Department>(departmentServiceInterface.getDepartment(department),
				org.springframework.http.HttpStatus.OK);
	}
	
	@HystrixCommand(ignoreExceptions = {SecondgreaterThanFirstException.class} ,fallbackMethod ="additionFallback" )
	@GetMapping(value = "/sum")
	public ResponseEntity<Integer> addition(@RequestParam("first") Integer first,
			@RequestParam("second") Integer second)
			throws FirstgreaterThanSecondException, SecondgreaterThanFirstException {
		if (first > second)
			throw new FirstgreaterThanSecondException("First value is greater than second");
		else if (first < second)
			throw new SecondgreaterThanFirstException("second value is greater than first");
		return new ResponseEntity<Integer>(first + second, org.springframework.http.HttpStatus.OK);

	}
	
	public ResponseEntity<Integer> additionFallback(@RequestParam("first") Integer first,
			@RequestParam("second") Integer second){
		return new ResponseEntity<Integer>(first*second , org.springframework.http.HttpStatus.OK);
	}
	
	
}
