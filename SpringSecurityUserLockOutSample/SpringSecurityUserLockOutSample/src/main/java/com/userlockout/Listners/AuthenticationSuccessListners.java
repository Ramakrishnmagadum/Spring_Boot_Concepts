package com.userlockout.Listners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.userlockout.dao.UsersessionDao;
import com.userlockout.entity.UserSession;

@Component
public class AuthenticationSuccessListners {
    @Autowired
	UsersessionDao userDao;
	
	@EventListener
//	# "AuthenticationSuccessEvent" this Event will execute when Login Successfully done....On this time we will get 
//	UserName , Authorities , IPAddress , SessionId and so on......
	public void start(AuthenticationSuccessEvent event) {
		System.out.println(event);
		System.out.println("AuthenticationSuccessEvent Is Excuted...");
		
//		# On Loggin Successfully -->we add UserSession Details to this table ...so we can track number of requests fails ...if requests are more than 3 then we are suspending the user...
		UserSession user=new UserSession();
		user.setSessionStart(LocalDate.now());
		user.setUsername(event.getAuthentication().getName());	
		user.setSessionId(event.getAuthentication().getDetails().toString().substring(event.getAuthentication().getDetails().toString().indexOf("RemoteIpAddress:")
				,event.getAuthentication().getDetails().toString().indexOf("SessionId") ));
		user.setIpAddress(event.getAuthentication().getDetails().toString().substring(event.getAuthentication().getDetails().toString().indexOf("SessionId:")));
		userDao.save(user);
		System.out.println("Values are inserted to this Table UserSession :"+ user);
	}
}
