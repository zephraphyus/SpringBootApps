package com.demo.rest.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.rest.spring.dao.UserDetailsDAO;
import com.demo.rest.spring.entity.UserDetails;

@Service
public class UserDetailsService {
	@Autowired
	private UserDetailsDAO ud;
	

	//@Override
	@Transactional
	public List getud() {
		// TODO Auto-generated method stub
		return ud.getAllDetails();
	}
	
	//@Override
	@Transactional
	public void addud(UserDetails userd) {
		// TODO Auto-generated method stub
	 ud.addUser(userd);
	}

	@Transactional
	public Date getDate(int  userid) {
		return ud.getDate(userid);
	}



}
