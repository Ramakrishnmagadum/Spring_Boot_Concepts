package com.sample.SpringProject.PropertySourceone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MyConfig.class);
		Teacher teacher=container.getBean("teacher", Teacher.class);
		teacher.teaching();
		
//		This line will close/Destroy the Container...
		container.registerShutdownHook();
	}
}
