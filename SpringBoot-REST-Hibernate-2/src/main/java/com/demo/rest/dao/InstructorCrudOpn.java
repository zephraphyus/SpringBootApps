package com.demo.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.rest.entity.Instructor;
import com.demo.rest.entity.InstructorDetail;

@Repository
public class InstructorCrudOpn {

private EntityManager entityManager; 	

@Autowired
public InstructorCrudOpn(EntityManager entityManager) {
	super();
	this.entityManager = entityManager;
}
@Transactional	
public void add(Instructor instructor)
{
	
	//creating a session
	//System.out.println("Instructor Details::::::::::>"+ids);
	Session session=entityManager.unwrap(Session.class);
	
	
	//getting the result
	System.out.println("Instructor::::::::::> 1"+instructor);
	//setting the null value
//	instructor.setInstructorDetail(null);
	System.out.println("Instructor::::::::::> 2"+instructor);
	
//	instructor.setInstructorDetail(ids);	
	System.out.println("Instructor::::::::::> 3"+instructor);
	
session.save(instructor);

}

@Transactional
public List<Instructor> getinstructor()
{
	Session session=entityManager.unwrap(Session.class);
	
	Query qs=session.createQuery("from Instructor",Instructor.class);
	
	return qs.getResultList();
	
}

@Transactional
public Instructor deleteInstructor(int id)
{
	
	Session sc=entityManager.unwrap(Session.class);
	Instructor instructor=sc.get(Instructor.class, id);
	sc.delete(instructor);
	//delete the instructor as well as istructor detail becoz of cascade ALL
System.out.println(":::::: Deletion of the Instructor");
	return instructor;
}
}
