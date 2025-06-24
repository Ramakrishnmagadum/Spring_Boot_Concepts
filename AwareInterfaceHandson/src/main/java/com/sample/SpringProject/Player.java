package com.sample.SpringProject;

import org.springframework.beans.factory.BeanNameAware;

//BeanNameAware -->this interface implementes the "Aware" Interface--->
//BeanNameAware This interface helps to Get Name of the Bean....Before inserting into Container....
public class Player implements BeanNameAware {

	public Player() {
		super();
		System.out.println("Player constructer Initialized..");
	}

	public void setBeanName(String name) {
		System.out.println("#BeanNameAware");
		System.out.println("Player Bean Name is : " + name);
		
		System.out.println("\n  \n");
	}

}
