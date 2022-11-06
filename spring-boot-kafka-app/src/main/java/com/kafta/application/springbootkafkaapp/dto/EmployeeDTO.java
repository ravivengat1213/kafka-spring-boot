package com.kafta.application.springbootkafkaapp.dto;

import com.kafta.application.springbootkafkaapp.model.Employees;

public class EmployeeDTO {

	private int empId;
	private String designation;
	
	private Employees employees;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", designation=" + designation + ", employees=" + employees + "]";
	}
	
	
}
