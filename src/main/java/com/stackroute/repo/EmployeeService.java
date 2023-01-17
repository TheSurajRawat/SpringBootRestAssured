package com.stackroute.repo;
import java.util.List;

import com.stackroute.model.Employee;
public interface EmployeeService {
	
	public boolean addEmployee(int empId, String empName, String Address);
	public boolean addEmployee(Employee emp);
	
	public Employee findEmployeeByempId(int empId);
	public List<Employee> findEmployeeByName(String name);
	public List<Employee> findAll();
	
	public boolean deleteEmployeeByEmpId(int empId);
	public boolean deleteEmployee(Employee emp);
	
	public Employee updateEmployee(Integer empId,Employee emp);
}
