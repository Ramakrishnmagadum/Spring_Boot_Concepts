package com.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("second")
@ComponentScan
public class SecondConfig {

	public SecondConfig() {
		System.out.println("#SecondConfig");
	}

}
