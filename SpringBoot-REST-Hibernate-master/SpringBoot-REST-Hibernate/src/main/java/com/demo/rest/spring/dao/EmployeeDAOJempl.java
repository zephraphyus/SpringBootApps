package com.demo.rest.spring.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.rest.spring.entity.Employee;

@Repository	
public class EmployeeDAOJempl implements EmployeeDAO {
    @Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		// Create Query
		Query theQuery=entityManager.createQuery("from Employee");
		//execute the query
		
		return theQuery.getResultList();
	}

	@Override
	public Employee findById(int theid) {
		// TODO Auto-generated method stub
Employee e=entityManager.find(Employee.class,theid);

return e;
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		
		Employee empl=entityManager.merge(emp);
		
		emp.setId(empl.getId());
		

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
Query q=entityManager.createQuery("delete from Employee where id=:empId");
	q.setParameter("empId",theId);
	q.executeUpdate();
	}

	@Override
	public Map getthedefvalue() {
		// TODO Auto-generated method stub
		return null;
	}

}
