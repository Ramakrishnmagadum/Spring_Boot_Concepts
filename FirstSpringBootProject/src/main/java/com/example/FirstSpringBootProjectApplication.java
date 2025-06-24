package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.AutoConfiguration.MyAutoBean;

@SpringBootApplication //this annotation combination of  @Configuration,  @EnableAutoConfiguration,  @ComponentScan
public class FirstSpringBootProjectApplication {

	public static void main(String[] args) {
//		--this both line code work same as below code
//		SpringApplication application =new SpringApplication(FirstSpringBootProjectApplication.class);
//		application.run();
		
		ConfigurableApplicationContext container = SpringApplication.run(FirstSpringBootProjectApplication.class, args);//here args are passing the server port number...
		MyApp myApp=container.getBean("myApp", MyApp.class);
		System.out.println(myApp.getAppName());
		
		
//		@AutoConfiguration Concept
		MyAutoBean myAutoBean = container.getBean(MyAutoBean.class);
		System.out.println("MyAutoBean created "+ myAutoBean);
	}

}
