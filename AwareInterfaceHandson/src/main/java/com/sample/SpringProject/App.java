package com.sample.SpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(MyConfig.class);
		container.getBean("player1", Player.class);
		container.getBean("player2", Player.class);
		
		
	}
}
