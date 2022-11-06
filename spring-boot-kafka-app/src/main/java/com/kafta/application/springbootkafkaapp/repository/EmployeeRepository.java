package com.kafta.application.springbootkafkaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafta.application.springbootkafkaapp.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

}
