package com.sample.SpringProject.PropertySourceone;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoPrinter {
	
	@Autowired
	Person person;
	
	@Autowired
	Student student;
	
	@Autowired
	ModelMapper modelMapper;
	
//	by Default values are present in PersonBean --->Those value need to add into StudentObject For that we use External Library Object ...
//	For That we will use @Bean Instead of @component to Created classes Object
//	BCZ---> @Component used to help only Customized or own Create Object ----> But For External Liberty To Create Object will yuse @Bean
//	@Bean --> used to Create Object For Create Class and External Libery Objects..........
	public void PrintStudent(){
		modelMapper.map(person, student);
		System.out.println(student);
	}

}
