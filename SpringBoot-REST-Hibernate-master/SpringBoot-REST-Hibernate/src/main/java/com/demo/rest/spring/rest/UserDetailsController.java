package com.demo.rest.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.spring.entity.UserDetails;
import com.demo.rest.spring.service.UserDetailsService;

@RestController
@RequestMapping("/bpi") 
public class UserDetailsController {

	@Autowired
	private UserDetailsService uds;

	
	@GetMapping("/getud")
	public List<UserDetails> getMap()
	{
		return uds.getud();
	}
	
	@PostMapping("/addUserz")
	public void addUser(@RequestBody UserDetails udz)
	{
		 uds.addud(udz);
	}
	
   @GetMapping("/getuserDate")
   public String getUserId(@RequestParam("id") int id)
   {
	   System.out.println("the uds "+uds.getDate(id));
	   return "{\"Date\":\""+uds.getDate(id)+"\"}";
   }
   
   
   
   
   
   
   }
