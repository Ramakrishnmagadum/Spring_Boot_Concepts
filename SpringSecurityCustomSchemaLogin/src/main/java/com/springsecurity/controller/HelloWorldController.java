package com.springsecurity.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class HelloWorldController {

	@GetMapping("/hello")
	@ResponseBody
	public String PrintHello() {
		return "Hello  Welcome Back to Selenium Expresss";
	}
	
	
	
	@GetMapping("/")
	public String PrintHelloWorld(Principal principal , Authentication authentication , Model model) {
		String username = principal.getName();
		System.out.println("User name is : "+username);
		Collection<? extends GrantedAuthority> auth = authentication.getAuthorities();
		System.out.println("authorities : "+auth);
		model.addAttribute("username",username);
		model.addAttribute("roles",auth);
		return "home-page";
	}

	@GetMapping("/bye")
	@ResponseBody
	public String Bye() {
		return "Bye bye Guys  !!";
	}
	
	
	@PostMapping("/Locker")
	@ResponseBody
	public String Locker() {
		return "Welcome to Money Wolrd....";
	}
	
	@GetMapping("/trainer")
	public String showTrainer() {
		return "trainer-dashboard";
	}
	
	@GetMapping("/coder")
	public String showCoder() {
		return "coder-dashboard";
	}
	
	@GetMapping("/accessdenied")
	public String accessDeniedPage() {
		return "access-denied";
	}
	
}
