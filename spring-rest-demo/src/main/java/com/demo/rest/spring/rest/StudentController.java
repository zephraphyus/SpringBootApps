package com.demo.rest.spring.rest;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> st;
	
	//define @PostConstruct to load the student data ..only once!
	//this will load the students data only once 
	@PostConstruct
	public void loadData()
	{
		
	    st=new ArrayList<>();
		st.add(new Student(1,"Sanjiv","Rai"));
		st.add(new Student(2,"Qwerty","qwer"));
		st.add(new Student(3,"wsad","qwe"));
		
		
	}
	
	
@GetMapping	("/students")	
public List<Student> getStudent(){
	return st;
}
//define end point for "/students/{studentId}" --return student as index
@GetMapping	("/students/{studentId}")	
public Student getStudent(@PathVariable int studentId)
{

	for(Student s:st)
{
if(s.getId()==studentId)	
{
	return s;
}
}

	throw new StudentNotFoundException("Student id not found "+studentId);
}

//adding an exception handler for handling the exception
/*
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException excep)
{
	//create a StudentErrorResponse	
	StudentErrorResponse error=new StudentErrorResponse();
	//return ResponseEntity
	error.setStatus(HttpStatus.NOT_FOUND.value());
	error.setMessage(excep.getMessage());
	error.setTimeStamp(System.currentTimeMillis());
	
	//return ResponseEntity

	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
//add another exception handler to catch any exception (catch all)
//handle generic Exception
/*@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(Exception excep)
{
	//create a StudentErrorResponse	
	StudentErrorResponse error=new StudentErrorResponse();
	//return ResponseEntity
	error.setStatus(HttpStatus.BAD_REQUEST.value());
	error.setMessage(excep.getMessage());
	error.setTimeStamp(System.currentTimeMillis());
	
	//return ResponseEntity

	
	return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
*/
}

