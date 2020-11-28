package com.demo.rest.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	//defines the fields
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="youtube_channel")
private String youtubeChannel;

@Column(name="hobby")
private String hobby;

public InstructorDetail() {
	super();
}
//refer to instructorDetail property in the Instructor class
@OneToOne(mappedBy="instructorDetail",cascade=	
{CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//this is //mapped by InstructorDetail property in the instructor class
private Instructor isntructor;
//it tells Hb to look at the instructorDetail property in the Instructor class
//Use info form the instructor JoinColumn
public InstructorDetail(String youtubeChannel, String hobby) {
	this.youtubeChannel = youtubeChannel;
	this.hobby = hobby;
}



public void setIsntructor(Instructor isntructor) {
	this.isntructor = isntructor;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getYoutubeChannel() {
	return youtubeChannel;
}

public void setYoutubeChannel(String youtubeChannel) {
	this.youtubeChannel = youtubeChannel;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}

@Override
public String toString() {
	return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
}


}
