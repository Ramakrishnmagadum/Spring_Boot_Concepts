package com.sample.SpringProject.PropertySourceone;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Teacher implements InitializingBean, DisposableBean {
	List<String> subjects;

//	first Stage of Bean Life Cycle is 
//	Bean Instantiation ---> Means it will call the constructor and Create the Object --> But Object doesnot have any value in it 
//  Still Value need to be initailize....	
	public Teacher() {
		super();
		System.out.println("Teacher Constructer Initialized...");
	}

//	---------------------  Init Method Concept   ---------------------------
//here value will initialize...---> But need to call this method Externally
//	There are two ways to call it --> 1. @PostConstruct  2. AfterPropertiesSet()--(Inside  the InitalizeBean Interface)
//	@PostConstruct  //This will call after constructor Executes..... //	1st Way to call init Method
	public void init() {
		subjects = new ArrayList<String>();
		subjects.add("maths");
		subjects.add("English");
		subjects.add("Science");
	}	
//	2nd Way to call init Method
//	This method will call when Initialize Done --> Value injected to Bean or Depedencies Injection all Done...
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertiesSet Method called");
		init();
	}
//--------------------------------------------------------------------------------
	
	
	public void teaching() {
		for (String sub : subjects) {
			System.out.println("Teaching " + sub);
		}
	}


//----------------  Destroy Method Concept -------------------
//	@PreDestroy   . //	1st Way to call destroyMethod Method
	public void destroyMethod() {
		System.out.println("Destroy Method called..");
	}
//	2nd Way to call destroyMethod Method
	public void destroy() throws Exception {
		destroyMethod();
	}
//---------------------------------------------------------------
}
