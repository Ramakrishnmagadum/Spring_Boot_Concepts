package com.springdataJPA;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdataJPA.DAO.StudentDao;
import com.springdataJPA.config.AppConfig;
import com.springdataJPA.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class); //# for this class implementations provided --"JpaRepository" 
    	
    	Student std=new Student();
    	std.setName("name");
    	std.setAddress("address");
//    	# saveStudent ---This is doing Operations..
    	studentDao.save(std);
		System.out.println("Record inserted");
		
		List<Student> studentsList = studentDao.findAll();
		for(Student list : studentsList) {
			System.out.println(list);
		}
    }
    
}
