package com.springsecurity;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer  implements WebApplicationInitializer  {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext  webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(MyConfig.class);
		DispatcherServlet dispatcher= new DispatcherServlet(webApplicationContext);
		Dynamic servlet = servletContext.addServlet("myDispactherServlet", dispatcher);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
