package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class webIntializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(ControllerMapper.class);

		DispatcherServlet dispatcher = new DispatcherServlet(webApplicationContext);
		Dynamic servlet = servletContext.addServlet("mydispactherservlet", dispatcher);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);

	}
}
