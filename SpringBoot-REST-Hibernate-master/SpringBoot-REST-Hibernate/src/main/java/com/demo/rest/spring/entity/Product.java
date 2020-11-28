package com.demo.rest.spring.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Product {

private String productname;

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

@Override
public String toString() {
	return "Product [productname=" + productname + "]";
}	
	
	
}
