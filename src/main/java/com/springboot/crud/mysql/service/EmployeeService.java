package com.springboot.crud.mysql.service;

import java.util.List;

import com.springboot.crud.mysql.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
