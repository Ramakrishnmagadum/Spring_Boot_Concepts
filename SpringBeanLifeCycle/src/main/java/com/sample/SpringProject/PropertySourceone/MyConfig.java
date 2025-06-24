package com.sample.SpringProject.PropertySourceone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
public class MyConfig {
	
// 3rd Way To Call the Init Method...
//	@Bean(initMethod="init")
//	public Teacher teacher() {
//		return new Teacher();
//	}
	
	
	// 3rd Way To Call the Destroy Method...
//		@Bean(destroyMethod="destroyMethod")
//		public Teacher teacher() {
//			return new Teacher();
//		}

}
