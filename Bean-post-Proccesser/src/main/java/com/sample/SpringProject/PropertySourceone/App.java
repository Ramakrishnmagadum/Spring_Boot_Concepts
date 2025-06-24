package com.sample.SpringProject.PropertySourceone;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MyConfig.class);
		container.getBean(laptop.class).chargeLaptop();
		
		System.out.println("*************  End  *********");
	}
}
