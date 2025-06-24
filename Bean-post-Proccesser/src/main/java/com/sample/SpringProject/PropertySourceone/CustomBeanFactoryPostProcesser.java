package com.sample.SpringProject.PropertySourceone;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//This Class will execute only once during the Container creating ,this is first Object will get create and 
///this will allow to modify the metadata of Beans present in Container...
//We can Modify Scope , BeanName and so on ........
@Component
public class CustomBeanFactoryPostProcesser implements BeanFactoryPostProcessor{
	
	public CustomBeanFactoryPostProcesser() {
		System.out.println("CustomBeanFactoryPostProcesser Constructer Initialized.....");
	}

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("#CustomBeanFactoryPostProcesser");
		String[] BeanDefinitionNames = beanFactory.getBeanDefinitionNames();
		System.out.println("-----    Priniting the BenaDefinitionNames inside CustomBeanFactoryPostProcesser Class   -------");
		for(String BeanDefinitionName : BeanDefinitionNames) {
			System.out.println(BeanDefinitionName);
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println("Checking scope of the Bean");
		System.out.println("Laptop is Singleton Scope "+ beanFactory.isSingleton("laptop"));
		System.out.println("------------------------------------------------------------------");
	}
}
