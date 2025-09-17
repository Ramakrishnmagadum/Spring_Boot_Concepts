package com.repositoryAnnotation.JPAdao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.repositoryAnnotation.entity.SampleBean;

@Repository  //# This Annotation will helps in (If Any exception comes then this will handle the Exception form SpringFramework .....So its easy to read the exception and helpful)
//@Component   //# This Annotation will helps in (this will helps in CRUD Opertation as @Repository Annotation will do )  --> But Disadvantages is --> it will handle exception with Javax or Hibernate or JDBC like that....
public class SampleDaoUsingJPA {
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void save() {
		SampleBean bean=new SampleBean();
		bean.setCity("Belagavi");
		bean.setName("2025-08-18 13:10:25.044  WARN 27388 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning\r\n" + 
				"2025-08-18 13:10:25.189  INFO 27388 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\r\n" + 
				"2025-08-18 13:10:25.521  INFO 27388 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''");
		try {
			entityManager.persist(bean);
			System.out.println("Data Inserted to SampleBean through Spring Data JPA...");
		}catch(DataAccessException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}
	}

}
