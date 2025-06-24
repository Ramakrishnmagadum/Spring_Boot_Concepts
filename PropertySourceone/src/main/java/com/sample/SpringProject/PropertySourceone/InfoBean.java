package com.sample.SpringProject.PropertySourceone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class InfoBean {
//	fetching the properties from same project  --->From abc.properties File
	@Value("${name}")
	private String name;
	
//	This is coming from PropertySourceTwo Project ---> this is different Project from their we are getting the values..
	@Value("${role}")
	private String role;
	
//	This value are coming form Vm Arguments  > App.java > RunAsConfiguration > VM Arguments
//	And VM arguments Varibale name Starts with "-D{name ofvarible}" Example: "-Dname=Ramakrishna"
	@Value("${exp}")
	private String exp;
	
	
//	This value are coming from Environment Arguments  > App.java > RunAsConfiguration > Environment
	@Value("${address}")
	private String address;


	@Override
	public String toString() {
		return "MyConfig [name=" + name + ", role=" + role + ", exp=" + exp + ", address=" + address + "]";
	}
}
