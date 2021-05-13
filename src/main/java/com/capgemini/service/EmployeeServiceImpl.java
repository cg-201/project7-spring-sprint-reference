package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Employee;
import com.capgemini.exception.EmployeException;
import com.capgemini.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean createEmployee(Employee employee) {
		
		// Service is right plaice for Validations before db related activitites
		employeeRepository.save(employee);
		
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee findById(int id)  {
		if(!employeeRepository.existsById(id)) {
			throw new EmployeException("Employee Not Found");
		}
		
		Employee e =  employeeRepository.findById(id).get();
		return e;
	}

}
