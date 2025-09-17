package com.repositoryAnnotation.JDBCTemplatedao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository  //# This Annotation will helps in (If Any exception comes then this will handle the Exception form SpringFramework .....So its easy to read the exception and helpful)
//@Component   //# This Annotation will helps in (this will helps in CRUD Opertation as @Repository Annotation will do )  --> But Disadvantages is --> it will handle exception with Javax or Hibernate or JDBC like that....
public class SampleDaoUsingJDBCTemplate {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save() {
		try {
		String sql="inser into xsample (name ,city) values ('Sample Name' ,'Belagavi')";
		jdbcTemplate.execute(sql);
		System.out.println("Data Inserted to SampleBean through JdbcTempalte");
		}catch(DataAccessException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}
	}

}
