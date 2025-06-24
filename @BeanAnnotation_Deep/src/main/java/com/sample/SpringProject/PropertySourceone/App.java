package com.sample.SpringProject.PropertySourceone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(MyConfig.class);
		container.getBean(StudentInfoPrinter.class).PrintStudent();
		
		
//		--------------------------------------------
		container.getBean(Film.class).startfilming();
	}
}
