package com.stackroute.model;

import org.springframework.stereotype.Component;


//POJO Class plain object java class
@Component
public class Employee{
	
	private Integer empId;
	private String employeeName;
	private String empCity;
	
	public Employee() {
		super();
	}



	public Employee(Integer empId, String employeeName, String empCity) {
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.empCity = empCity;
	}
	public int getEmpId() {
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
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	

}
