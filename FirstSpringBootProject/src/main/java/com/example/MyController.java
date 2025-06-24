package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@ResponseBody
	@GetMapping("/home")
	public String getHomePage() {
		return "Hello Welcome to Home Page";
	}

}
