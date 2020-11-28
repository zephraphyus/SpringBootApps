package com.demo.rest.spring.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.rest.spring.entity.Product;
import com.demo.rest.spring.entity.UserDetails;


@Repository
public class UserDetailImplementation implements UserDetailsDAO {

	private EntityManager entityManager;	
	
	///setting up the constructor injection
	@Autowired
	public UserDetailImplementation(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<UserDetails> getAllDetails() {
		// TODO Auto-generated method stub
		Session currentsession=entityManager.unwrap(Session.class);
		//create a query
	Query<UserDetails> thequery=currentsession.createQuery("from UserDetails",UserDetails.class);
		System.out.println(thequery);
	//execute query and get result list
	List<UserDetails> emp=thequery.getResultList();
	
		
		//execute query and get Result		
		return emp;
	}

	
	
	@Override
	public void addUser(UserDetails uds)
	{
			
		
		Session cs=entityManager.unwrap(Session.class);
        Set<Product> pro=uds.getProduct(); 
		UserDetails q=cs.get(UserDetails.class,uds.getUserId());
		System.out.println(q);

		if(q!= null)
{
q.updateProduct(pro);

System.out.println(q);

//	cp.saveOrUpdate(uds);
this.saveorUpdates(q);
}
else
{
	this.saveorUpdates(uds);
	
}	
	}

	public void saveorUpdates(UserDetails qw)
	{
		Session cp=entityManager.unwrap(Session.class);
cp.saveOrUpdate(qw);	
	}
	
	
	@Override
	public Date getDate(int id) {
		// TODO Auto-generated method stub
		
		Session cs=entityManager.unwrap(Session.class);

		UserDetails uds=cs.get(UserDetails.class,id);
		
		return uds.getDob();
	}
}
