package com.sanjiv.springstarterdemo.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjiv.springstarterdemo.topic.Topic;

@RestController
public class CourseController {

	
@Autowired	
private CourseService courseService;	
	
	@RequestMapping("/topics/{id}/courses") ///to get all courses for a topic
	public List<Course> sayhi(@PathVariable int id) //already converted into json becoz of the RestControlller
	{
		return courseService.getallcourses(id);
	}
	
//	@RequestMapping("/topics/id")   get request ::localhost:8080/topics/id?id=3
//	@ResponseBody
//	public Topic getTopic(@RequestParam int id)
//			
//			//@PathVariable int id)
//	{
//		return courseService.getTopic(id);
//	}

	@RequestMapping("/topics/{topicid}/courses/{id}")   ///localhost:8080/topics/2
	public Course getTopic(@PathVariable int id)
	{
		return (Course) courseService.getCourse(id);
	}

	//POST method
@RequestMapping(method=RequestMethod.POST,value="/topics/{topicid}/courses")	
public void addTopic(@RequestBody Course course,@PathVariable int topicid)
{
	course.setTopic(new Topic(topicid,""));
	courseService.addValue(course);
}
	
//PUT method
@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicid}/courses/{id}")	
public void updateTopic(@RequestBody Course topic,@PathVariable int topicid,@PathVariable int id)
{
courseService.updateValue(id,topic);
}	

//DELETE method
@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicid}/courses/{id}")	
public void deleteTopic(@PathVariable int id)
{
courseService.deleteValue(id);
}	

}
