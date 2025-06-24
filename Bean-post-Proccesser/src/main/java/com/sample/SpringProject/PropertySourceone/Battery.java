package com.sample.SpringProject.PropertySourceone;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Battery {
	
	public Battery() {
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("-----  Instantiation Stage Starts   ----");
		System.out.println("Battery Constructer Initialized...");
	}

	public void charge() {
		System.out.println("Battery --> charge Method called ");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Battery Init Method called");
	}
}
