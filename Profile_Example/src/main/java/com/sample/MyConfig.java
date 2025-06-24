package com.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.sample.Dao.StudentBean;

@Configuration

//@Import annotation is used to import additional configuration classes or regular component classes into the Spring application context.
//What Can You Import?
//1.  You can pass the following types to @Import:
//2.  @Configuration classes
//3.  Regular component classes
//4.  ImportSelector implementations
//5.  ImportBeanDefinitionRegistrar implementations

@Import(value= {SecondConfig.class})
@Profile("first")
@ComponentScan
public class MyConfig {

	public MyConfig() {
		System.out.println("#MyConfig");
	}
	
	
//	This bean will create when "student" profile is activated.....Else this bean will not create...
//	@profile annotation on top of the @Bean....
	@Bean
	@Profile("student")
	public StudentBean studentBean() {
		return new StudentBean();
	}
	
	

}
