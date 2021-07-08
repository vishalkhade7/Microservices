package com.vk1.entities;

public class Employee {
private Long employeeID;
private String employeeName;
private Department department;
public Long getEmployeeID() {
	return employeeID;
}
public void setEmployeeID(Long employeeID) {
	this.employeeID = employeeID;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}


}
