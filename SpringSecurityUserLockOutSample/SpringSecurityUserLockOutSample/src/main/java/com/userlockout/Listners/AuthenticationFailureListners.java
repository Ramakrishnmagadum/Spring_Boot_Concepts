package com.userlockout.Listners;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.stereotype.Component;

import com.userlockout.dao.CustomersDao;
import com.userlockout.dao.UsersessionDao;
import com.userlockout.entity.Customer;
import com.userlockout.entity.UserSession;

@Component
public class AuthenticationFailureListners {
	@Autowired
	UsersessionDao userDao;

	@Autowired
	CustomersDao customerDao;

	@EventListener
//	# "AbstractAuthenticationFailureEvent" this Event will execute when Login fails ....
	public void start(AbstractAuthenticationFailureEvent event) {
		System.out.println(event);
		System.out.println("AbstractAuthenticationFailureEvent Is Excuted...");
boolean flag=true;
		Customer loginCustomer = new Customer();
		
//		# Once Login Fails then checking customer details based on the Username
		List<Customer> customers = customerDao.findAll();
		for (Customer customer : customers) {
			if (customer.getUsername().equals(event.getAuthentication().getName())) {
				loginCustomer = customer;
			}
		}
		
//		# If Customer is present with giving username 
//		Updating RequestNumber and If RequestNumber Reaches 3...then that Customer is suspending ...
		if (loginCustomer != null) {
			List<UserSession> users = userDao.findAll();
			for (UserSession user : users) {
				if (user.getUsername().equals(loginCustomer.getUsername())) {
					flag=false;
					if (user.getNumberOfRequests() >= 3) {
						loginCustomer.setEnabled(false);
						customerDao.save(loginCustomer);
					} else {
						user.setNumberOfRequests(user.getNumberOfRequests() + 1);
						userDao.save(user);
					}
				}
			}
		}
		
		
//		# If with Username Customers are not present then ....Upadting the UserSession.....with random userName.....
		if(flag) {
			UserSession user=new UserSession();
			user.setSessionStart(LocalDate.now());
			user.setUsername(event.getAuthentication().getName());	
			user.setSessionId(event.getAuthentication().getDetails().toString().substring(event.getAuthentication().getDetails().toString().indexOf("RemoteIpAddress:")
					,event.getAuthentication().getDetails().toString().indexOf("SessionId") ));
			user.setIpAddress(event.getAuthentication().getDetails().toString().substring(event.getAuthentication().getDetails().toString().indexOf("SessionId:")));
			userDao.save(user);
		}

	}
}
