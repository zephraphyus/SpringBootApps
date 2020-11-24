package com.sanjiv.springstarterdemo.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer> 
{
//CrudRepository	
public List<Course> findByTopicId(int topicid);   ///find the topic variable in the course class then find the id of that topic class write the method in camel case topic ---> Topic , id---> Id

public Course findByName(String name);

}
