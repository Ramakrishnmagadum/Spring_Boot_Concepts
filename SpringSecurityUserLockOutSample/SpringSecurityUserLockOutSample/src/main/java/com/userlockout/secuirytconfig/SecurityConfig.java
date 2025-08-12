package com.userlockout.secuirytconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@EnableJpaRepositories("com.userlockout.dao")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	DataSource datasource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("ram")
//		.password("ram@123")
//		.roles("Admin")
//		.and()
//		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("select username , password , is_Enabled  from customers where username =?")
		.authoritiesByUsernameQuery("select username , roles  from customers where username =?" )
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/h2-console/**").permitAll()
//		.anyRequest()
//		.authenticated()
//		.and().formLogin()
//		.and().httpBasic();
//	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/h2-console/**");
	}
}
