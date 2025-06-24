package com.sample.SpringProject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextInfo implements ApplicationContextAware {

	public ApplicationContextInfo() {
		super();
		System.out.println("ApplicationContextInfo Constructer Initialized....");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("#ApplicationContextAware");
		
		boolean singleton = applicationContext.isSingleton("applicationContextInfo");
		System.out.println("ApplicationContextInfo is :" +singleton);
		System.out.println("\n  \n");
	}

}
