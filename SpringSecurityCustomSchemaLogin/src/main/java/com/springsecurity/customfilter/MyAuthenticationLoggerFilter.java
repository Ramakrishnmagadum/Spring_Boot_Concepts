package com.springsecurity.customfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//#  This Filter we need to register ---Then only Spring will call this Filter internally...

//#  in SecurityConfig.java -->Inside configure(HttpSecurity http) Method ---> we registered This Filter .....so it will print the Loggers..whenever tis filter will be called...
public class MyAuthenticationLoggerFilter  implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
//		# Once Login Done , Then Authentication Object will be stored in SecurityContextHolder.java 
//		....From their we can access the "Authentication" Object and get Username.......
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) {
			System.out.println("UserName is " +authentication.getName() +"  Roles of the User :- "+authentication.getAuthorities());
		}
		
//		# This will delegate the Request to next Filter
//		---Means this will give it to next filer and next will do thier work after completing this filter work....
		chain.doFilter(request, response);
	}

}
