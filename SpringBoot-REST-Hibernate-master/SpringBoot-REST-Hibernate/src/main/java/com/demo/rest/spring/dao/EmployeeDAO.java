package com.demo.rest.spring.dao;

import java.util.List;
import java.util.Map;

import com.demo.rest.spring.entity.Employee;

public interface EmployeeDAO {

public List<Employee> findAll();	

public Employee findById(int theid);

public void save(Employee emp);

public void deleteById(int theId);


public Map getthedefvalue();



}
