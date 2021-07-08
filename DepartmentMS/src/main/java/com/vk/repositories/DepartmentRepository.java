package com.vk.repositories;

import org.springframework.stereotype.Repository;

import com.vk.entities.Department;

@Repository
public class DepartmentRepository implements DepartmentInterface {

	
	public  Department getDepartmentbyEmployeeId(Long employeeId) {
		if(employeeId== 101)
		return new Department(1, "FSDAM", 101);
		
		return new Department(0, "null", 0);
	}
}
