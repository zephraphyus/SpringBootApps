package com.demo.rest.spring.dao;

import java.util.Date;
import java.util.List;

import com.demo.rest.spring.entity.UserDetails;

public interface UserDetailsDAO {

public List<UserDetails> getAllDetails(); 	
public void addUser(UserDetails ud);
public Date getDate(int id);
}
