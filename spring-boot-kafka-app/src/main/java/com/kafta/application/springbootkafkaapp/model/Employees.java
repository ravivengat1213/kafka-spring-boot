package com.kafta.application.springbootkafkaapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee", schema = "sys")
@NamedQuery(name="Employees.findAll", query="SELECT c FROM Employees c")
public class Employees {

	@Id
	@Column(name="emp_id")
	private Integer empId;

	@Column(name="emp_name")
	private String employeeName;

	@Column(name="ph_num")
	private String phoneNumber;

	@Column(name="address")
	private String address;
	
	@Column(name="designation")
	private String designation;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "{'empId':'" + empId + "', 'employeeName':'" + employeeName + "', 'phoneNumber':'" + phoneNumber
				+ "', 'address':'" + address + "', 'designation':'" + designation + "'}";
	}
}
