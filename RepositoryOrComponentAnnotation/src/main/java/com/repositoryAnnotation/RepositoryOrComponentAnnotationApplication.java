package com.repositoryAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.repositoryAnnotation.JDBCTemplatedao.SampleDaoUsingJDBCTemplate;
import com.repositoryAnnotation.JPAdao.SampleDaoUsingJPA;

@SpringBootApplication
public class RepositoryOrComponentAnnotationApplication implements CommandLineRunner{

	@Autowired
	SampleDaoUsingJDBCTemplate sampleDaoUsingJDBCTemplate;
	
	@Autowired
	private SampleDaoUsingJPA sampleDaoUsingJPA;
	
	public static void main(String[] args) {
		SpringApplication.run(RepositoryOrComponentAnnotationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		# this line will call the JDBCTemplate Type Save Method....
		sampleDaoUsingJDBCTemplate.save();
		
//		# this line will call the Spring Data JPA Type Save Method....		
//		sampleDaoUsingJPA.save();
	}

}
