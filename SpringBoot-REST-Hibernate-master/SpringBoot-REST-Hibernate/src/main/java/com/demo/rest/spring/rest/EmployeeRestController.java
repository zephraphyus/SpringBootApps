package com.demo.rest.spring.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.spring.entity.Employee;
import com.demo.rest.spring.entity.UserDetails;
import com.demo.rest.spring.service.EmployeeServiceImp;

@RestController
@RequestMapping("/api") 
public class EmployeeRestController {
///quick and dirty inject employee dao
	@Autowired
	private EmployeeServiceImp empservice;
//express "/employeesand return list of employees
	@GetMapping("/getListOfStudent")
	public List<Employee> findAll(){
		return empservice.findAll();
	}
	
	@GetMapping("/getStudent/{id}")
	public Employee findbyId(@PathVariable int id){
	if(empservice.findById(id)==null)
		{
	throw new RuntimeException("Employee not found for id "+id);
		}
	return  empservice.findById(id);
	
	}
	//post mapping 
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
	//also just in case they pass an id in JSON .. setid to 0	
	//this is to force a save of new item instead of update	
		
	theEmployee.setId(0);
	empservice.save(theEmployee);
	
	return theEmployee;
	
	}
	
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		empservice.delete(id);
	}
	
	@GetMapping("/getmap")
	public Map getMap()
	{
		return empservice.getm();
	}

	
	
}
