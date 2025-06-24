package com.sample.SpringProject.PropertySourceone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class laptop {

	private Battery battery;

	@Autowired
	public void setBattery(Battery battery) {
		
		System.out.println("Setting properties...");
		this.battery = battery;
	}
	
	public laptop() {
		System.out.println();
		System.out.println("Laptop Constructor Initialized...");
	}
	
	public void chargeLaptop() {
		battery.charge();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Laptop Init Method called");
	}
}
