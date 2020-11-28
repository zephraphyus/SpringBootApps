package com.demo.rest.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.rest.spring.dao.EmployeeDAO;
import com.demo.rest.spring.dao.UserDetailsDAO;
import com.demo.rest.spring.entity.Employee;
import com.demo.rest.spring.entity.UserDetails;
@Service
public class EmployeeServiceImp  implements EmployeeService{
    
	@Autowired
	@Qualifier("employeeDAOJempl")
	private EmployeeDAO employeeDAO;
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theemp) {
		// TODO Auto-generated method stub
		employeeDAO.save(theemp);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Map getm() {
		// TODO Auto-generated method stub
		return employeeDAO.getthedefvalue();
	}

		
	
}
