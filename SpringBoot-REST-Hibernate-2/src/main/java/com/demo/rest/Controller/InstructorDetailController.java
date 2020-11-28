package com.demo.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.dao.InstructorCrudOpn;
import com.demo.rest.entity.Instructor;

@RestController
@RequestMapping("/cpi")
public class InstructorDetailController {

	@Autowired
	private InstructorCrudOpn Icrud;
	
@PostMapping("/addInstructor")	
public void addInstructor(@RequestBody Instructor instr)	
{
	Icrud.add(instr);
}

@GetMapping("/getInstructor")
public List<Instructor> getInstructors()
{
	return Icrud.getinstructor();
	
}

@DeleteMapping("/deleteInstructor")
public Instructor getInstructors(@RequestParam int id)
{
	return Icrud.deleteInstructor(id);
	
}
}
