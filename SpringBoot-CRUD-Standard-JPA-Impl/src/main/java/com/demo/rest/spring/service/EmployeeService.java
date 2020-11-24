package com.demo.rest.spring.service;

import java.util.List;
import java.util.Map;

import com.demo.rest.spring.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
public void save(Employee theemp);

public void delete(int id);
public Map getm();
	
	
}
