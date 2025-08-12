package com.sample.SpringEvents.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@ComponentScan("com")
public class AppConfig {

//	# This Will make Async Operation 
//	Means : If Thread is blocked for one Event then it will create One Thread for other Events ...so it won't wait 
//	 it will make work as parallel ---------
	@Bean(name= {"applicationEventMulticaster"})
	public SimpleApplicationEventMulticaster getSimpleApplicationEventMulticaster() {
		SimpleApplicationEventMulticaster bean =new SimpleApplicationEventMulticaster();
//		This will "SimpleAsyncTaskExecutor" make Async Type....
//		To make Sync "syncTaskExecutor" will use
		bean.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return bean;
		
	}
	
//	this code will execute and make its as ...ASync or Sync
//	ApplicationContext.java > ConfigurableApplicationContext.java > AbstractApplicationContext.java > initApplicationEventMulticaster() Method
	
	/** 
	protected void initApplicationEventMulticaster() {
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();
		
//		#### By Default beanFactory doesn't have "SimpleApplicationEventMulticaster" Obejct in Container So it will execute Else statement  
//      #### This Will execute when --We create Object to make ASync............
		if (beanFactory.containsLocalBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME)) {
			this.applicationEventMulticaster =
					beanFactory.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
			if (logger.isTraceEnabled()) {
				logger.trace("Using ApplicationEventMulticaster [" + this.applicationEventMulticaster + "]");
			}
		}
		
//		##### This will execute ByDefault ---this will make Sync .....Only one Thread will be thier ....
		else {
			this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
			beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, this.applicationEventMulticaster);
			if (logger.isTraceEnabled()) {
				logger.trace("No '" + APPLICATION_EVENT_MULTICASTER_BEAN_NAME + "' bean, using " +
						"[" + this.applicationEventMulticaster.getClass().getSimpleName() + "]");
			}
		}
	}
	**/
}
