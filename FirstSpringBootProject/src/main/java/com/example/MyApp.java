package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("abc.properties")   //--this is annotation will look the our customized  .properties file , we can give any name just location need to mention it will fetch it ..
//@PropertySource("Myproperties/abc.properties")
public class MyApp {
	
//	from application.properties we can get the value ----> By using Expression Language
//  application.properites will load while starting the server itself
//	By default spring will  pick form  location   1. src/main/resources/application.properties   or 2. src/main/resources/config/application.properties
	@Value("${myapp.name}") 
	private String appName;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
}
