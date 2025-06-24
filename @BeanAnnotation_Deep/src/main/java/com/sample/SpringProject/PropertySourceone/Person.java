package com.sample.SpringProject.PropertySourceone;

import org.springframework.stereotype.Component;

@Component
public class Person {
	
	private String name="ramakrishna";
	private String address="BLR";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}
}
