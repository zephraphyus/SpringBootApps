package com.sanjiv.springstarterdemo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //Spring Business Service
public class TopicService {

	
//private	List<Topic> topics =Arrays.asList(new Topic(1,"spring core")
//				             ,new Topic(2,"spring mvc")
//				             ,new Topic(3,"Spring AOP"));
    @Autowired
	private TopicRepository topicReopsitory;  ///to get the values from topicRepo
	
	
	

public List<Topic> getalltopics()
{
	//return (List<Topic>) topicReopsitory.findAll();
List<Topic> topics=new ArrayList();
topicReopsitory.findAll().forEach(topics::add);
return topics;
}

public Topic getTopic(int id)
{
//return	topics.stream().filter(t -> t.getId()==id).findFirst().get();
return topicReopsitory.findById(id).orElse(null);
}

public void addValue(Topic obj)
{
	topicReopsitory.save(obj);
}

public void updateValue(int id,Topic obj)
{
	topicReopsitory.save(obj);//use the same method can do both update and add if row doesnt exist it adds or else it update the existing one
}

public void deleteValue(int id) {
	// TODO Auto-generated method stub
	topicReopsitory.deleteById(id);
}
}



