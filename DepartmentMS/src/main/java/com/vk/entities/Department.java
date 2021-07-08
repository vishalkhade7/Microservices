package com.vk.entities;

public final class Department {

	private long departmentid;
	
	private String depatmentName;
	
	private long employeeId;

	public long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(long departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepatmentName() {
		return depatmentName;
	}

	public void setDepatmentName(String depatmentName) {
		this.depatmentName = depatmentName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", depatmentName=" + depatmentName + ", employeeId="
				+ employeeId + "]";
	}

	public Department(long departmentid, String depatmentName, long employeeId) {
		super();
		this.departmentid = departmentid;
		this.depatmentName = depatmentName;
		this.employeeId = employeeId;
	}
	
	
}
