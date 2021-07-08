package com.vk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.entities.Department;
import com.vk.repositories.DepartmentInterface;



@Service
public class DepartmentService implements DepartmentServiceInterface {
    @Autowired
	DepartmentInterface departmentInterface;
	
    public Department getDepartment(Department department) {
		
		
		return departmentInterface.getDepartmentbyEmployeeId(department.getEmployeeId());
		
	}
}
