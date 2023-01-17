package com.stackroute.repo;

import java.util.ArrayList;
import com.stackroute.model.Employee;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stackroute.model.Employee;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> employee = new ArrayList<Employee>();
	@Override
	public boolean addEmployee(int empId, String employeeName, String empCity) {
		
		return employee.add(new Employee(empId,employeeName,empCity));
	}

	@Override
	public boolean addEmployee(Employee empObj) {
		
		return employee.add(empObj);
	}

	@Override
	public Employee findEmployeeByempId(int empId) {
		for (Employee emp : employee)
			{
			if(emp.getEmpId()==empId)
				return emp;
			}
		return null;
			
	}
	@Override
	public List<Employee> findEmployeeByName(String name) {
		List<Employee> newEmp = new ArrayList<Employee>();
		for (Employee emp : employee)
		{
		if(emp.getEmployeeName().equals(name))
			newEmp.add(emp);
	
		}
	return newEmp;
	}
	

	@Override
	public boolean deleteEmployeeByEmpId(int empId) {
		for (Employee emp : employee)
		{
		if(emp.getEmpId()==empId) {
			employee.remove(emp);
			return true;
		}
		}
		return false;
	}

	@Override
	public List<Employee> findAll() {

		return employee;
	
	}

	@Override
	public Employee updateEmployee(Integer empId,Employee emp) {
	
		for(int i = 0; i < employee.size(); i++) {
			Employee empObj = employee.get(i);
			if(empObj.getEmpId() == empId) {
				employee.set(i, emp);
				return empObj;
			}
		}
		return emp;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		for(Employee empObj: employee)
		{
			if(empObj.getEmpId() == emp.getEmpId() && empObj.getEmployeeName().equals(emp.getEmployeeName()) &&  empObj.getEmpCity().equals(emp.getEmpCity())) {
				employee.remove(empObj);
				return true;
			}
		}
		return false;
	}
	
}
