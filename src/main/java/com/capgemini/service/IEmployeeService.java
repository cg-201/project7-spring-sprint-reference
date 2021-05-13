package com.capgemini.service;

import com.capgemini.entities.Employee;

public interface IEmployeeService {

	
	public boolean createEmployee(Employee employee) ;
	
	public boolean updateEmployee(Employee employee);
	
	public Employee findById(int id);
}
