package com.springsecurity.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springsecurity.DTO.Customer;

@Repository(value="customerDAOImpl")
public class CustomerDAOImpl implements CustomerDAO{

	
	public CustomerDAOImpl() {
		super();
		System.out.println("CustomerDAOImpl object is created....");
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Customer> findCustomerByCustomerName(String name) {
//  make DB call and load the customer by Customer name 
		String sql ="select * from customer where xusername =?";
		Object[] args= {name};
//		# if we use QueryObject --> it should have record in database in case if its returning Empty or null then it will throw an error....so instead of this will use Query...
//		Customer queryForObject = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<Customer>(Customer.class));
		 List<Customer> customers = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Customer>(Customer.class));
		return customers;
	}

}
