package com.example.AutoConfiguration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;


//@AutoConfiguration   --> This Annotation having  @Configuration(proxyBeanMethods = false) So this class "MyAutoConfig" will not execute by default We need to Config  Externally to trigger this class ---->
//How we can Config by Externally to trigger this class..
// under src/main/resources >> META-INF >> Spring > .import(with Extension) create file and add Import of this class Then this class will trigger
//To call this AutoConfiguration Annotated classes --> we are following the standard Like SpringBoot is Following
//Explanation --> Maven Dependencies > Spinr-boot-autoconfiguration Jar File >META-INF > Spring > under this .import file having all the @AutoConfiguration Annotated classes Import statement --->BCZ of this those classes are getting executed..

@AutoConfiguration

//This annotation will allow to excute inside this class code ---> only when MyAutoBean class is present in mentioned path else -->it will execute inside Code...or will not enter the inside of this class..
//@ConditionalOnClass(name="com.example.AutoConfiguration.MyAutoBean")
public class MyAutoConfig {
	
	
	public MyAutoConfig() {
		super();
		System.out.println("MyAutoConfig ");
		// TODO Auto-generated constructor stub
	}

//	this will check "sampleBean" this named Bean exists or not Inside ApplicationContext(Container) --> if exists inside the Container then it will allow to enter inside the class else not..
//	If not exits then "MyAutoBean" Object also not create...
	@ConditionalOnBean(name ="sampleBean")
	@Bean
	public MyAutoBean myAutoBean() {
		return new MyAutoBean();
	}

}
