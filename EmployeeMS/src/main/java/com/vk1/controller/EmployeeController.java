package com.vk1.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vk1.entities.Department;
import com.vk1.entities.Employee;
import com.vk1.exception.DepartmentNotFoundException;



@RestController
public class EmployeeController {

	@Autowired
	DiscoveryClient client;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value="/employee")
	public ResponseEntity<Employee> getEmployeeDetails(@RequestBody Department department){
	
	//Start: To fetch the microservice from Eureka server
		List<ServiceInstance> instances=client.getInstances("DEPARTMENTMS");
		ServiceInstance instance=instances.get(0);
		URI departmentMS=instance.getUri();
	// End: To fetch the microservice from Eureka server 
		
		System.out.println(departmentMS.toString());
		ResponseEntity<Department> result = 
				new RestTemplate().postForEntity(departmentMS+"/department", department, Department.class);
		
		Department d= result.getBody();
		System.out.println(result.getBody());
		Employee employee=new Employee();
		employee.setEmployeeID(department.getEmployeeId());
		employee.setDepartment(d);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping(value="/employeewithLoadbalancer")
	public Employee getEmployeeDetails1(@RequestBody Department department) throws DepartmentNotFoundException{
	 
		
		Department result = 
				restTemplate.postForObject("http://DEPARTMENTMS/department", department, Department.class);
		
		if(result.getDepatmentName().equals("null")) {
			throw new DepartmentNotFoundException("DepartmentNotFound");
		}
		Employee employee=new Employee();
		employee.setEmployeeID(department.getEmployeeId());
		employee.setDepartment(result);
		return employee;
	}
	
	@GetMapping(value ="/addition")
	public Integer getAddition(@RequestParam("first") Integer first, @RequestParam("second") Integer second) {
		//Start: To fetch the microservice from Eureka server
				List<ServiceInstance> instances=client.getInstances("DEPARTMENTMS");
				ServiceInstance instance=instances.get(0);
				URI departmentMS=instance.getUri();
			// End: To fetch the microservice from Eureka server 
				
				
				System.out.println(departmentMS.toString());
			
	//			ResponseEntity<Integer> result = new RestTemplate().getForEntity(departmentMS+"/sum?first="+first+"&second="+second, Integer.class);
				
				Integer result1 = new RestTemplate().getForObject(departmentMS+"/sum?first="+first+"&second="+second, Integer.class);
				
		//System.out.println(result.getBody());
		return result1;
	}
	
	

	

}
