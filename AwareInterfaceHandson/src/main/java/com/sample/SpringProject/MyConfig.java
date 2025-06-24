package com.sample.SpringProject;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan
public class MyConfig {

	@Bean(name = "player1")
	@Scope("prototype")
	public Player player() {
		return new Player();
	}

	@Bean(name = "player2")
	@Scope("prototype")
	public Player playersecond() {
		return new Player();
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource message= new ResourceBundleMessageSource();
		message.setBasename("greet");
		message.setDefaultEncoding("UTF-8");
		return message;
	}

}
