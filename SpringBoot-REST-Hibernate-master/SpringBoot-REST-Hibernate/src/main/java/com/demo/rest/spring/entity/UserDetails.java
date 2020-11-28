package com.demo.rest.spring.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class UserDetails {

	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)	
private int userId;

private String userName;


//one to one for vehicle










public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@JsonFormat(pattern="yyyy-MM-dd")
private Date dob;

@Lob
private String description;

@Embedded
private Address address;

@ElementCollection
private Set<Product> product=new HashSet<>(); 


public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}

public void updateProduct(Set<Product> proteas)
{
	for(Product q:proteas)
	{
		this.product.add(q);
	}
}

@Override
public String toString() {
	return "UserDetails [userId=" + userId + ", userName=" + userName + ", dob=" + dob + ", description=" + description
			+ ", address=" + address + ", product=" + product + "]";
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}


}
