package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class HelloWorldController {

	@GetMapping("/hello")
	@ResponseBody
	public String PrintHello() {
		return "Hello  Welcome Back to Selenium Expresss";
	}
	
	@GetMapping("/helloworld")
	public String PrintHelloWorld() {
		return "hello-world";
	}

	@GetMapping("/bye")
	@ResponseBody
	public String Bye() {
		return "Bye bye Guys  !!";
	}
	
}
