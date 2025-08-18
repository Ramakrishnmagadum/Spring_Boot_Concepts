package com.JdbcInternal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//@Configuration   //# commenting this line because --> should execute this files code......
public class AppConfig {
//	Gettting values from the Application.properties By Using Keys....
	@Value("${spring.datasource.url}")
	String Url;
	
	@Value("${spring.datasource.username}")
	String Username;
	
	@Value("${spring.datasource.password}")
	String Password;

	@Bean
	public DataSource dataSource() {
//		##This Type of DataSource Object will not follow the Connection Pool
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl(Url);
//		dataSource.setUsername(Username);
//		dataSource.setPassword(Password);
//		return dataSource;
		
//		## This Type of DataSource will follow the Connection Pool Concept
//		Means it will create some number of connection object and keep it ready when server starts ..whenever DB call happens then it will readmaid Connection Object ...so it will not create new connection object each time....this advantages..
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl(Url);
		dataSource.setUser(Username);
		dataSource.setPassword(Password);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
}
