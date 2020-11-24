package com.sanjiv.springstarterdemo.course;

import javax.persistence.Entity;
//import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sanjiv.springstarterdemo.topic.Topic;

@Entity
public class Course {

	
@Id	
private int id;

private String name;
private String description;

@ManyToOne
private Topic topic;

public Course() {
	super();
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Topic getTopic() {
	return topic;
}



public void setTopic(Topic topic) {
	this.topic = topic;
}



public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Course(int id, String name, String description,int topicid) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.topic=new Topic(topicid,"");
}

}
