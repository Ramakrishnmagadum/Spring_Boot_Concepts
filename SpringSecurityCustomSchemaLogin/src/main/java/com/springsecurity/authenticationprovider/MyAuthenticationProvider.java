package com.springsecurity.authenticationprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springsecurity.DAO.CustomerDAOImpl;
import com.springsecurity.DTO.Customer;
//# This Is AuthenticationProvider Class --> Here Authentication Object will be present
//which is having "LoggedIn User Info" Like (Username ,password and Authorities so on )
@Component
public class MyAuthenticationProvider  implements AuthenticationProvider{

@Autowired
CustomerDAOImpl customerDAOImpl;

@Autowired
private  PasswordEncoder passwordEncoder;



//# Here I am Checking the Username and password is present in DB ,If Present it will return the Authentication Obejct in Retun else it will throws error...
public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	List<Customer> customer = customerDAOImpl.findCustomerByCustomerName(authentication.getName());
	String password=authentication.getCredentials().toString();
	if(customer.size()>0 ) {
		boolean flag= passwordEncoder.matches(password, customer.get(0).getXpassword());
		if(flag) {
			return new UsernamePasswordAuthenticationToken(customer.get(0).getXusername(), customer.get(0).getXpassword(), authentication.getAuthorities());
		}else {
			throw new UsernameNotFoundException("Username doesno't Not Found");
		}
		
	}else {
		throw new UsernameNotFoundException("Username doesno't Not Found");
	}
}

//# From Every HTTP Request :- It will convert HttpRequest  and Create Authentication Object based on **Filter.java File
//So Here "Class<?> authentication"  ---> From Filter.java File it will get One Authentication Type Object 
public boolean supports(Class<?> authentication) {	
//	Here I am comparing If both are same Object Then Only it will execute the Above authenticate() Methood ....ELse it will Skip it..
	return authentication.equals(UsernamePasswordAuthenticationToken.class);
}
}
