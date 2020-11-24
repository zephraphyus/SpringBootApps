package com.sanjiv.springstarterdemo.topic;

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

@RestController
public class TopicController {

	
@Autowired	
private TopicService topicService;	
	
	@RequestMapping("/topics")//by default get request for other need to be specified
	public List<Topic> sayhi() //already converted into json becoz of the RestControlller
	{
		return topicService.getalltopics();
	}
	
//	@RequestMapping("/topics/id")   get request ::localhost:8080/topics/id?id=3
//	@ResponseBody
//	public Topic getTopic(@RequestParam int id)
//			
//			//@PathVariable int id)
//	{
//		return topicService.getTopic(id);
//	}

	@RequestMapping("/topics/{id}")   ///localhost:8080/topics/2
	public Topic getTopic(@PathVariable int id)
	{
		return topicService.getTopic(id);
	}

	//POST method
@RequestMapping(method=RequestMethod.POST,value="/topics")	
public void addTopic(@RequestBody Topic topic)
{
	topicService.addValue(topic);
}
	
//PUT method
@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")	
public void updateTopic(@RequestBody Topic topic,@PathVariable int id)
{
topicService.updateValue(id,topic);
}	

//DELETE method
@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")	
public void deleteTopic(@PathVariable int id)
{
topicService.deleteValue(id);
}	

}
