package com.vk.repositories;

import com.vk.entities.Department;

public interface DepartmentInterface {
	
	Department getDepartmentbyEmployeeId(Long employeeId);
}
