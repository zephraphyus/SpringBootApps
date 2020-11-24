package com.sanjiv.springstarterdemo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //Spring Business Service
public class CourseService {

	
//private	List<Topic> topics =Arrays.asList(new Topic(1,"spring core")
//				             ,new Topic(2,"spring mvc")
//				             ,new Topic(3,"Spring AOP"));
    @Autowired
	private CourseRepository courseReopsitory;  ///to get the values from topicRepo
	
	
	

public List<Course> getallcourses(int id)
{
	//return (List<Topic>) courseReopsitory.findAll();
List<Course> courses=new ArrayList();
courseReopsitory.findByTopicId(id).forEach(courses::add);
return courses;
}

public Course getCourse(int id)
{
//return	topics.stream().filter(t -> t.getId()==id).findFirst().get();
return courseReopsitory.findById(id).orElse(null);
//return courseReopsitory.findByName("SpringAOP");
}

public void addValue(Course obj)
{
	courseReopsitory.save(obj);
}

public void updateValue(int id,Course obj)
{
	courseReopsitory.save(obj);//use the same method can do both update and add if row doesnt exist it adds or else it update the existing one
}

public void deleteValue(int id) {
	// TODO Auto-generated method stub
	courseReopsitory.deleteById(id);
}
}



