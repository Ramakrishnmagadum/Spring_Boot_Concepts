package com.sample.SpringProject.PropertySourceone;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
//this is getting the values from the same project .properties file that's Why it stats with "classpath:"
@PropertySource("classpath:com/sample/SpringProject/PropertySourceone/abc.properties")

//this values are coming from other project(different Project)   ---> that's why its start with "file:"
@PropertySource("file:D:\\Workspace\\SpringBoot\\PropertySourcetwo\\src\\main\\java\\propertytwo.properties")
public class MyConfig {

}
