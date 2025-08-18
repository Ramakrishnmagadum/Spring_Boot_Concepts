package com.JdbcInternal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

//#By this Annotation --Only Providing the DB Information in Application.properties It will Create AutoDBConnection
//Means --> It will create DataSource and Jdbctemplate Object ---> so Just by Using @Autowired Annotation we can get JdbcTemplate Object and we can connect to DB ...
//@SpringBootApplication


//# exclude= {DataSourceAutoConfiguration.class , JdbcTemplateAutoConfiguration.class}  
//---> this will exclude will doing AutoConfiguration ....Means it will Configure automatically DataSource and JdbcTemplate Object
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class , JdbcTemplateAutoConfiguration.class})
public class SpringBootJdbcInternalApplication implements CommandLineRunner{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcInternalApplication.class, args);
		System.out.println("Application Started");
	}

	
//	This Method will get execute once Container gets Loads...
	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute( "insert into xstudent (name ,address) values('ramakrishna', 'Belagavi')");		
		System.out.println("Record Inserted Successfully.....");
	}

}
