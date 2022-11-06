package com.kafta.application.springbootkafkaapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafta.application.springbootkafkaapp.model.Employees;
import com.kafta.application.springbootkafkaapp.repository.EmployeeRepository;
import com.kafta.application.springbootkafkaapp.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employees> getEmployeeDetails() {
		List<Employees> empList = new ArrayList<>();
		empList = employeeRepository.findAll();
		return empList;
	}

	@Override
	public Optional<Employees> getEmployee(int empId) {
		Optional<Employees> emp = employeeRepository.findById(empId);
		return emp;
	}

	
}
