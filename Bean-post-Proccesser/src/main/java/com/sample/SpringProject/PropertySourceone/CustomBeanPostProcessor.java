package com.sample.SpringProject.PropertySourceone;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
	
//This method will call After @postConsttruct or Init Method called 
//	We can modify Object ..
public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	System.out.println("#postProcessAfterInitialization");
	System.out.println(bean.getClass().getName() +" Bean name "+ beanName);
	return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
}

//This method will call Before @postConsttruct or Init Method called 
//We can modify Object ..
public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	System.out.println("#postProcessBeforeInitialization");
	System.out.println(bean.getClass().getName() +" Bean name "+ beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
}
