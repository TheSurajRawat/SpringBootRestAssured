package com.stackroute.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.Employee;
import com.stackroute.repo.EmployeeService;
// To send Request and accept Response
@RestController
public class HomeController {

	@Autowired
	private EmployeeService empService;
	//Handling Request
	@GetMapping("/")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<String>("WELCOME TO REST ASSURED APPLICATION", HttpStatus.OK);
	}
	@PostMapping("/employee/addnew")
	public ResponseEntity<Boolean> addnewEmployee(@RequestParam Integer empId,
													@RequestParam String employeeName,
													@RequestParam String empCity){
		Boolean isSuccess = empService.addEmployee(empId, employeeName, empCity);
		if(isSuccess) {
		return new ResponseEntity<Boolean>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.CONFLICT);
		}
	}
	@PostMapping("/employee/addnewobj")
	public ResponseEntity<Boolean> addnewEmployee(@RequestBody Employee emp){
		
		Boolean isSuccess = empService.addEmployee(emp);
		if(isSuccess) {
			return new ResponseEntity<Boolean>(HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.CONFLICT);
			}
		
	}
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> findEmployeeByEmpNo(@PathVariable Integer empId){
		Employee emp = empService.findEmployeeByempId(empId);
		if(emp != null) {
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/employee/findByName")
	public ResponseEntity<List> findEmployeeByEmpName(@RequestParam String employeeName){
		List<Employee> emp = empService.findEmployeeByName(employeeName);
		if(emp != null) {
			return new ResponseEntity<List>(emp,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/employee/findAll")
	public ResponseEntity<List> findAllEmployee()
	{
		return new ResponseEntity<List>(empService.findAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
		public ResponseEntity<Boolean> deleteEmployeeByEmpId(@PathVariable Integer empId){
		Boolean isSuccess = empService.deleteEmployeeByEmpId(empId);
		if(isSuccess) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.CONFLICT);
			}
		}
	
	@DeleteMapping("/employee/deleteEmployee")
	public ResponseEntity<Boolean> deleteEmployeeObj(@RequestBody Employee emp){
	Boolean bool = empService.deleteEmployee(emp);
	if(bool) {
		return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.CONFLICT);
		}
	}
	
	
	@PutMapping("/updateEmployee/{empId}")
	public ResponseEntity<Employee> updateEmployeeByEmpId(@PathVariable Integer empId, @RequestBody Employee empObj ){
		Employee emp = empService.findEmployeeByempId(empId);
		if(emp != null) {
			Employee updateEmp =  empService.updateEmployee(empId,empObj);
			return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }

}


