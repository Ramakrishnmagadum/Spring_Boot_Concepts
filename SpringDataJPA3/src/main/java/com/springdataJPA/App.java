package com.springdataJPA;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdataJPA.dao.StudentDao;
import com.springdataJPA.entity.Student;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
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
