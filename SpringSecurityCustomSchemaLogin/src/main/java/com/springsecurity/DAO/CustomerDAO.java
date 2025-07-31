package com.springsecurity.DAO;

import java.util.List;

import com.springsecurity.DTO.Customer;

public interface CustomerDAO {
	
	List<Customer> findCustomerByCustomerName(String name);
}
