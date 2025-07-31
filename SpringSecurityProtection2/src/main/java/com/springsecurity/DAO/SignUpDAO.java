package com.springsecurity.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

import com.springsecurity.DTO.SignUpDTO;

@Component
public class SignUpDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	public void addUser(SignUpDTO signUpDTO) {

//		# this code we are writing to insert the data ...
//		jdbcTemplate.update("insert into users (username , password ,enabled ) values (? , ?, ?)" ,signUpDTO.getUsername(),bCryptPasswordEncoder.encode(signUpDTO.getPassword()),true);
//		jdbcTemplate.update("insert into authorities  values (? , ?)" ,signUpDTO.getUsername(),"USER");
//		System.out.println("User is inserted "+signUpDTO);

//		# will use JbdcUserDetailManager Class to perform CRUD Operation itself...
		UserDetails user = User.withUsername(signUpDTO.getUsername()).password(signUpDTO.getPassword()).roles("USER")
				.build();
		jdbcUserDetailsManager.createUser(user);

	}

	public void deleteUser(String userName) {

//		# will use JbdcUserDetailManager Class to perform CRUD Operation itself...
		jdbcUserDetailsManager.deleteUser(userName);
	}
	
	public UserDetails GetUser(String userName) {

//		# will use JbdcUserDetailManager Class to perform CRUD Operation itself...
		 return jdbcUserDetailsManager.loadUserByUsername(userName);
	}
	
	public void changePassword(String oldPassword , String newPassword) {

//		# will use JbdcUserDetailManager Class to perform CRUD Operation itself...
		  jdbcUserDetailsManager.changePassword(oldPassword, newPassword);
	}
}
