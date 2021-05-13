package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;
import com.capgemini.exception.EmployeException;
import com.capgemini.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/")
	public boolean createEmployee(@RequestBody Employee employee) {
		
		employeeServiceImpl.createEmployee(employee);
		return true;
	}
	
	@PostMapping("/v1/")
	public ResponseEntity<Boolean> createEmployeeV1(@RequestBody Employee employee) {
		
		employeeServiceImpl.createEmployee(employee);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable int id) throws EmployeException {
		Employee employee = employeeServiceImpl.findById(id);
		return employee;
	}
	
	@GetMapping("/v1/{id}")
	public ResponseEntity<Employee> findByIdV1(@PathVariable int id) {
		Employee  employee = employeeServiceImpl.findById(id);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
}
