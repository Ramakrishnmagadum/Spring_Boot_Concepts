package com.springdataJPA.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdataJPA.entity.Student;


//# Implementing JpaRepository ...it will give CRUD Operations Methods directly no need to write logic for this
//@EnableJpaRepositories  --this annotation will helps to provide implementation for this interface
//----> it will create proxy implementation class that class has all the required CRUD operations methods in it ...
public interface StudentDao extends JpaRepository<Student, Integer>{

}
