package com.springsecurity.securityconfig;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
@EnableWebSecurity(debug=true)
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;

	
//	# we are  loading  values from DB 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder);
	}
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		# we can store  multiple Username and Password also 
//		# Here Username and Password are storing in the "InMemory" or "ServerMemory".....
//        auth.inMemoryAuthentication()
//		.withUser("ram").password("{bcrypt}$2a$10$600im9eYsOvuWqbJFiwPk./fuCHVpUk4XgKIz4lgUYnwotau7vV9O")  //{bcrypt}  ---> this is for "BCryptPasswordEncoder"
//		.roles("admin")
//		.and()
//		.withUser("ramakrishna").password("{bcrypt}$2a$10$hNk0.S6vGqS0b3zuPyeUb.lSE3lfFONKJEM1h1TC9Yl9dNvrfrfHu").roles("user");
		
	
		
		
//		# Using UserDetails Interface and User Class..
//		1st way to store the user...
//		ArrayList<GrantedAuthority> roles =new ArrayList<GrantedAuthority>();
//		SimpleGrantedAuthority role1=new SimpleGrantedAuthority("ADMIN");
//		SimpleGrantedAuthority role2=new SimpleGrantedAuthority("USER");
//		roles.add(role1);
//		roles.add(role2);
//		User user =new User("ramakrishna","ram123",roles);
		
		
//		#Using UserDetailsManagaer Interface Stroing the UserDetails Or User Information inside the InMemory or Database...
//		                                                     UserDetailsManagaer (Interface)
//		1. InMemoryUserDetailsManager implements UserDetailsManagaer          2. JdbcUserDetailsManager implements UserDetailsManagaer
//		InMemoryUserDetailsManager userdetailsManager =new InMemoryUserDetailsManager();
		
//		2nd way to store the user...
//		UserDetails user1 = User.withUsername("rama").password("ram123").roles("ADMIN","USER").build();
//		UserDetails user2 = User.withUsername("prashant").password("pra123").roles("ADMIN","USER").build();
//		
//		userdetailsManager.createUser(user1);   //## adding UserInforamtion to "UserdetailsManager"
//		userdetailsManager.createUser(user2);   //## adding UserInforamtion to "UserdetailsManager"
//		
//		auth.userDetailsService(userdetailsManager).passwordEncoder(passwordEncoder);   //## adding UserInforamtion to "AuthenticationManagerBuilder"
//		
//	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/hello").permitAll()  //# This line will permit this URL without any authentication
//		.antMatchers("/helloworld" , "/bye" ,"/Locker").authenticated()  //# this url will ask authentication 
//		.and().formLogin().loginPage("/customLogInPage")  //# This will be CustomLogIn Page --->  whenever it will ask authentication "/customLogInPage" this page will open .....this will be the login Page
//		.and().httpBasic()
//		.and().logout().logoutUrl("/MyCustomLogout");//# This is Logout Features will introduce ...and we provided Logout URL also.. whenerver we hit this "MyCustomLogout" Url ..Page will get LogOut 
	
//	    http.csrf().disable();   //# This will disable the CSRF
		//CSRF: Cross Site Request Furgye ---. Without CSRF we can attack/take access to thier actions by Knowing the "URL" ...so to avoide this will use CSRF
//		Evertime CSRF will generate random ID so if it matches then only it allow to access else it will add restriction for that..for this we have one filter also called "csrfFilter"
		
		
		
		http.authorizeRequests()
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
