package com.kafta.application.springbootkafkaapp.service;

import java.util.List;
import java.util.Optional;

import com.kafta.application.springbootkafkaapp.model.Employees;

public interface EmployeeService {

	public List<Employees> getEmployeeDetails();
	
	public Optional<Employees> getEmployee(int empId);
}
