package com.vk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.entities.Department;
import com.vk.services.DepartmentServiceInterface;

@RestController
public class DepartmentController {
    @Autowired
	DepartmentServiceInterface departmentServiceInterface;
 @PostMapping(value="/department")   
 public ResponseEntity<Department> getDepartment(@RequestBody Department department){
	 System.out.println("department: "+department);
	 return new ResponseEntity<Department>(departmentServiceInterface.getDepartment(department),org.springframework.http.HttpStatus.OK);
 }
 
 
 @GetMapping(value ="/sum")
	public ResponseEntity<Integer> addition(@RequestParam("first") Integer first, @RequestParam("second") Integer second) {
	 
	 return new ResponseEntity<Integer>(first+second ,org.springframework.http.HttpStatus.OK); 
	
	}
}
