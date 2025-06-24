package com.sample.SpringProject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//BeanFactoryAware --> this interface helps to Get Container and it will give contianer and By this Container we can check information under container
public class BeanInfo implements BeanFactoryAware {

	public  BeanInfo() {
		super();
		System.out.println("BeanInfo Constructer Initialized......");
	}
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("#BeanFactoryAware");
		boolean singleton = beanFactory.isSingleton("player1");
		System.out.println("This Bean is SingelTone : "+singleton);
		System.out.println("\n  \n");
	}

}
