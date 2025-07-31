package com.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.DAO.CustomerDAOImpl;
import com.springsecurity.DAO.MySecurityUser;
import com.springsecurity.DTO.Customer;

@Service
public class CustomerUserDetailsServiceImpl implements UserDetailsService{
    @Autowired
	CustomerDAOImpl customerDAOImpl;
	
//    # this method we overrided from "UserDetailsService" and we can write our own logics here.....
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		#this will return Customer Details By Username...
		List<Customer> customers = customerDAOImpl.findCustomerByCustomerName(username);
		
		if(customers.isEmpty()) {
			throw new UsernameNotFoundException("This xusername "+username+ " not found in DB");
		}
//		#This will create Users/User Info ..this UserDetails Object  will help us For Authentication , Authorization Puspose...
//		UserDetails user = User.withUsername(customers.get(0).getXusername()).password(customers.get(0).getXpassword()).roles(customers.get(0).getXrole()).build();
//		return user;
		
		
//		#Custom User Class to store the user Information....
		return new MySecurityUser(customers.get(0).getXusername() , customers.get(0).getXpassword() ,customers.get(0).getXrole());
	}

}
