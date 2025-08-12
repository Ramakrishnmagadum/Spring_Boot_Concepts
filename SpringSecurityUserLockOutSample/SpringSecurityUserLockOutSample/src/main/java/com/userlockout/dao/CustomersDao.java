package com.userlockout.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userlockout.entity.Customer;


public interface CustomersDao  extends JpaRepository<Customer, Integer>{

}
