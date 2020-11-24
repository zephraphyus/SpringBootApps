package com.sanjiv.springstarterdemo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service  //Spring Business Service
public class TopicService {

	
//private	List<Topic> topics =Arrays.asList(new Topic(1,"spring core")
//				             ,new Topic(2,"spring mvc")
//				             ,new Topic(3,"Spring AOP"));

	private	List<Topic> topics =new ArrayList<>(Arrays.asList(new Topic(1,"spring core")
            ,new Topic(2,"spring mvc")
            ,new Topic(3,"Spring AOP")));

	
public List<Topic> getalltopics()
{
	return topics;
}

public Topic getTopic(int id)
{
return	topics.stream().filter(t -> t.getId()==id).findFirst().get();
}

public void addValue(Topic obj)
{
	topics.add(obj);
}

public void updateValue(int id,Topic obj)
{
for (int i=0;i<topics.size();i++)
{
	if(topics.get(i).getId()==id)
	{
		topics.set(i,obj);
		return;
	}
}
}

public void deleteValue(int id) {
	// TODO Auto-generated method stub
	for (int i=0;i<topics.size();i++)
	{
		if(topics.get(i).getId()==id)
		{
			topics.remove(topics.get(i));
			return;
		}
	}}
}



