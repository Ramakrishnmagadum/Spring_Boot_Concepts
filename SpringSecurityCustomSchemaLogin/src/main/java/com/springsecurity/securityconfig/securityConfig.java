package com.springsecurity.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecurity.authenticationprovider.MyAuthenticationProvider;
import com.springsecurity.customfilter.MyAuthenticationLoggerFilter;
import com.springsecurity.service.CustomerUserDetailsServiceImpl;
@EnableWebSecurity(debug=true)
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;
	

	@Autowired
	CustomerUserDetailsServiceImpl customerUserDetailsServiceImpl;
	
	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;
//	# we are  loading  values from DB 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		# This will work with JdbcUserDetailsManagaer --it will use everything spring scurity provides
		
//		auth.jdbcAuthentication().dataSource(dataSource)
////		this two lines will execute or help only Login Time.......
//		.usersByUsernameQuery("select xusername , xpassword ,xenable from customer  where xusername = ?")  //# this will allow to login and authenticate by the xusername and xpassword
//		.authoritiesByUsernameQuery("select xusername ,xrole from customer  where xusername = ?")
//		.passwordEncoder(passwordEncoder);
		
		
//		## Writing own classes and Own Implemention for security....
//		here CustomerUserDetailsServiceImpl class -> refrence passing --in this we written our own "LoadUserByUsername" Method() ---> it will help us in case of login , in case changepassword (whenever LoadUserByUsername method will invoke that time our method will get invoke...
		auth.userDetailsService(customerUserDetailsServiceImpl).passwordEncoder(passwordEncoder);
		
//		# 2nd Way to Register the Custom-AuthenticationProvider
		auth.authenticationProvider(myAuthenticationProvider);
	}
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//		# This line will register the New Custom Filter in Order.................
		.addFilterAfter(new MyAuthenticationLoggerFilter(), UsernamePasswordAuthenticationFilter.class)
//		.authenticationProvider(myAuthenticationProvider) //# This is Custom AuthenticationProvider ...This will Execute Based On Which Authentication Object we are passing ....this thing will validate the Supports() Method in MyAuthenticationProvider.java File...
		.authorizeRequests()
		.antMatchers("/").authenticated()
//		.anyRequest().authenticated()  //# this line will make all the request should be authenticated....
		.antMatchers("/trainer").hasAnyAuthority("Trainer") //# this URL can be  accessed by only User Has "Trainer" Role
		.antMatchers("/coder").hasAnyAuthority("Coder")//# this URL can be  accessed by only User Has "Coder" Role
		.and().formLogin().loginPage("/customLogInPage").permitAll()  //# This will be CustomLogIn Page --->  whenever it will ask authentication "/customLogInPage" this page will open .....this will be the login Page
		.and().httpBasic()
		.and().logout().logoutUrl("/MyCustomLogout")//# This is Logout Features will introduce ...and we provided Logout URL also.. whenerver we hit this "MyCustomLogout" Url ..Page will get LogOut 
	    .and().exceptionHandling().accessDeniedPage("/accessdenied");
	}
}
