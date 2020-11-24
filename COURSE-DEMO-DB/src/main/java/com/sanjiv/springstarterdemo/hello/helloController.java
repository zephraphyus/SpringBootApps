package com.sanjiv.springstarterdemo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

	@RequestMapping("/hello")//by default get request for other need to be specified
	public String sayhi()
	{
		return "hi";
	}
}
