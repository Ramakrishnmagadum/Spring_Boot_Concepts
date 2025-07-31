package com.springsecurity.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//This will Activate Security and create chain of security filters...
//By default this annotation will create With this name "springSecurityFilterChain" Filter Chain 
//and By default "AbstractSecurityWebApplicationInitializer" with help of this class  ---> this "securtiyInitalizer" class will Register this "springSecurityFilterChain" Filter chain.... 
@EnableWebSecurity(debug=true)
public class securityConfig extends WebSecurityConfigurerAdapter{
	
//	This class going to helps us to create Spring Security Filter Chain
	
	
//--------------------  Trying to Login with UserName and Password (without anything)  ---------------------------
//	For first Time ---> if we are trying to do login --> Then It doesnot know where to look the password and username is present or not 
//	Means it does not know the AuthenticationProvider so we will get Error --No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken

	
//----------------------- Storing the Password and Username "InMemory" (Server memory called as In Memory)---------------------------
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		here we are stroing the data in plain text --this is easy to hack so spring inbuilt it will ask for passwordEncoder --use any passwordEncoder to secure the password
//		for that will get the error as --->There is no PasswordEncoder mapped for the id "null"
//      their are many PasswordEncoder are thier with that we can encode our password.........
		
//		-----------  NoOpPasswordEncoder -------------
//		auth.inMemoryAuthentication()
//		.withUser("ram")
//		.password("ram123")
//		.roles("admin");
		
//		----------BCryptPasswordEncoder -----------------
//		auth.inMemoryAuthentication()
//		.withUser("ram")
//		.password("$2a$10$600im9eYsOvuWqbJFiwPk./fuCHVpUk4XgKIz4lgUYnwotau7vV9O") //For BCryptPasswordEncoder ---> we should store in BCryptPasswordEncoder encoded format --BCZ --> when i enter "ram123" it will convert encoded format and comes here and check is it same or not , so we should store in BCryptPasswordEncoder Encoded format.. 
//		.roles("admin");
		
		
//		------ By Keys we can configure the PasswordEncoder ----------------
		auth.inMemoryAuthentication()
		.withUser("ram")  
//		.password("{noop}ram123")   //By specifying the key it will consider the PasswordEncoder Type --Example ={noop} ---> this NoopPasswordEncoder Type
		.password("{bcrypt}$2a$10$600im9eYsOvuWqbJFiwPk./fuCHVpUk4XgKIz4lgUYnwotau7vV9O")  //{bcrypt}  ---> this is for "BCryptPasswordEncoder"
		.roles("admin");
	}
	
//	this is Plain text Encoder 
//	in password Filed if i enter as "ram123" --> it will give as plain text and it will match from inmemory(sever memory as above mentioned) --if matching it will allow to go inside..
//	@Bean
//	PasswordEncoder getPasswordEncoder(){
//		return NoOpPasswordEncoder.getInstance();
//	}
	
//	----------BCryptPasswordEncoder -----------------
//	@Bean
//	PasswordEncoder getPasswordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
	
	
	
	
//	-----------------------Two Types of Authentication Filter --------------------
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/hello").permitAll()
//		.antMatchers("/helloworld").permitAll()
		.anyRequest().authenticated() //(this first line will Authenticate the Every incoming request if request is authenticated then only it will allow else not )

		
		.and().formLogin()  //(this is FormLogin Filter will activate  (UsernamePasswordAuthenticationFilter) this will show one login page and we can need to give login credentials  --> this is most secured one 
		.and().httpBasic(); //(this is BasicFilter (BasicAuthenticationFilter) normally if we are trying with postman then this filter will take care....But this is not secured one Bcz after login by this filter we can get username and password in cokkies ---in cokkies username and password will be stored in encoded format we can decoded it easly)...so this is not secured one...
	
		
//		-------------------------------------------------------------------------
//		we can activate both or we can activate only one or not one also 
//		.and().formLogin() -----------(to activate this line need to mention)
//		.and().httpBasic()-----------------(to activate this line need to mention)
		

//.DenyAll() method ----> this method will denyall the request means this is downtime..
//.permitAll()   --> this meth.....od will not Check security or Not Authenticate ...just it will allow all request no authentication
//.authenticate()  --> this method will land login page first --need to login then only it will allow the request...
//
//.anmatchers("/show").authenticate()  -->this method will only authenticate or show login page when request coming form /show url...
//.anmatchers("/contact" ,"/location").permitAll()  -->this method will not ask any authentication this url allow without authentication

	}
}
