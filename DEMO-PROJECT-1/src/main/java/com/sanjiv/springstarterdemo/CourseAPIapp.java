package com.sanjiv.springstarterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //let the spring know this is our main class whhere execution takes place
public class CourseAPIapp 
{

	public static void main(String[] args) {
    SpringApplication.run(CourseAPIapp.class,args);//run all the servlet opn
	}

}
