package com.springdataJPA;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdataJPA.DAO.StudentDaoImpl;
import com.springdataJPA.config.AppConfig;
import com.springdataJPA.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	StudentDaoImpl studentDao = context.getBean("studentDaoImpl",StudentDaoImpl.class);
    	
    	Student std=new Student();
    	std.setName("name");
    	std.setAddress("address");
//    	# saveStudent ---This is doing Operations..
    	studentDao.saveStudent(std);

		System.out.println("Record inserted");
    }
}
