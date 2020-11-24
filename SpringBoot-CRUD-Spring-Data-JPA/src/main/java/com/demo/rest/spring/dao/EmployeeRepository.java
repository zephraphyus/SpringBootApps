package com.demo.rest.spring.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}