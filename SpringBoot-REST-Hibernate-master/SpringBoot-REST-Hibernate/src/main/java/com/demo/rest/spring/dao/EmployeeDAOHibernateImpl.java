package com.demo.rest.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.rest.spring.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
//define field for entitymanager
private EntityManager entityManager;	
	
///setting up the constructor injection
@Autowired
public EmployeeDAOHibernateImpl(EntityManager entityManager) {
	super();
	this.entityManager = entityManager;
}

	@Override   ///no need to perform commit rollback 
	//@Transactional//not using persistence one //also it does all the transcational work
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
	//get the current hibernate session
		Session currentsession=entityManager.unwrap(Session.class);
		//create a query
	Query<Employee> thequery=currentsession.createQuery("from Employee",Employee.class);
		
	//execute query and get result list
	List<Employee> emp=thequery.getResultList();
	
		
		//execute query and get Result		
		return emp;
	}

	@Override
	//@Transactional
	public Employee findById(int theid) {
		//
		Session currentSession=entityManager.unwrap(Session.class);
		
	Employee theEmployee=currentSession.get(Employee.class,theid);
	
	return theEmployee;
	
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from Employee where id=:employeeId");
				theQuery.setParameter("employeeId", theId);
				theQuery.executeUpdate();
				}

	@Override
	public Map getthedefvalue() {
		// TODO Auto-generated method stub
		Map m=new HashMap();
		m.put("Key","Value");
		m.put("Message","the original Message");
		
		return m;
	}

	


}
