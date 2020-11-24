package com.course.dbapi;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JacksonDatabindingJsonDemoApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(JacksonDatabindingJsonDemoApplication.class, args);
	
	ObjectMapper mapper=new ObjectMapper();
	
	Student theStudent=mapper.readValue(new File("data/sample-full.json"), Student.class);
	
	System.out.println("id "+theStudent.getId());
	System.out.println("first name " + theStudent.getFirstName());
	System.out.println("last name " + theStudent.getLastName());
	///print the address
	Address add=theStudent.getAddress();
	System.out.println("Street ="+add.getCity());
	System.out.println("State ="+add.getState());
///printing the array of languages
	System.out.println("the languages are");
	for(String st:theStudent.getLanguages())
	{
		System.out.println(st);
	}
	
	}

}
