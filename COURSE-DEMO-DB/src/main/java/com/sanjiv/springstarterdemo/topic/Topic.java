package com.sanjiv.springstarterdemo.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

	
@Id	
private int id;

private String name;

public Topic() {
	super();
}
public Topic(int id, String name) {
	super();
	this.id = id;
	this.name = name;
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

}
