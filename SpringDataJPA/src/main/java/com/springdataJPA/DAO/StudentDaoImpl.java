package com.springdataJPA.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdataJPA.entity.Student;

@Repository
public class StudentDaoImpl {

//	# this will Give EntityManager Object with this we can perform CRUD Operations...
	@PersistenceContext
	EntityManager entityManager;	
	
	@Transactional
	public void saveStudent(Student std) {
		entityManager.persist(std);
	}
}
