package com.kafta.application.springbootkafkaapp.listener;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafta.application.springbootkafkaapp.dto.EmployeeDTO;
import com.kafta.application.springbootkafkaapp.model.Employee;
import com.kafta.application.springbootkafkaapp.model.Employees;
import com.kafta.application.springbootkafkaapp.service.EmployeeService;

@Service
public class KafkaConsumer {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplete;

	@KafkaListener(topics = "kafka-project", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumer Message : " + message);
	}
	
	@KafkaListener(topics = "kafka-project-2", groupId = "group_json", containerFactory = "employeeKafkaListenerContainerFactory")
	public void consumeJson(Employee employee) throws JsonProcessingException {
		Optional<Employees> empData = employeeService.getEmployee(employee.getEmpId());
		Employees emp = empData.get();
		System.out.println("Employee Id : " + emp.getEmpId());
		System.out.println("Employee Name : " + emp.getEmployeeName());
		System.out.println("Phone Number : " + emp.getPhoneNumber());
		System.out.println("Designation : " + emp.getDesignation());
		
		EmployeeDTO employeeDTO =  new EmployeeDTO();
		employeeDTO.setEmpId(employee.getEmpId());
		employeeDTO.setDesignation(employee.getDesignation());
		employeeDTO.setEmployees(emp);
		
//		producerJson(employeeDTO);
		
		System.out.println(employeeDTO.toString());
	}
	
	public void producerJson(EmployeeDTO employees) throws JsonProcessingException {
		String topic = "kafka-project-2";
		ObjectMapper Obj = new ObjectMapper();  
		kafkaTemplete.send(topic,  Obj.writeValueAsString(employees));
	}
}
