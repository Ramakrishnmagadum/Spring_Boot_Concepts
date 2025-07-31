package com.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class MyConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.postgresql.Driver");
		datasource.setUrl("jdbc:postgresql://localhost:5432/StudentManagement?currentSchema=customlogin");
		datasource.setPassword("postgres123");
		datasource.setUsername("postgres");
		return datasource;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager =new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource());
		
//		Here we can set every SQL Query :- For Delete user,update user ,get or load user , change password of the password .....for so many things we can write SQL Query...
		jdbcUserDetailsManager.setUsersByUsernameQuery("select xusername , xpassword ,xenable from customer  where xusername = ?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select xusername ,xrole from customer  where xusername = ?");
		jdbcUserDetailsManager.setChangePasswordSql("update customer set xpassword = ? where xusername = ?");
		jdbcUserDetailsManager.setDeleteUserSql("delete from customer where xusername = ?");
		jdbcUserDetailsManager.setDeleteUserAuthoritiesSql("delete from customer where xusername = ?");
		jdbcUserDetailsManager.setCreateUserSql("insert into customer (xusername, xpassword, xenable) values (?,?,?)");
		jdbcUserDetailsManager.setCreateAuthoritySql("insert into customer (xusername, xrole) values (?,?)");
		return jdbcUserDetailsManager;
	}
}
