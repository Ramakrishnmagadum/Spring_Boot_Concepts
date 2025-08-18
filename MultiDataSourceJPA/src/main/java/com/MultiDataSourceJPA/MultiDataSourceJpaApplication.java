package com.MultiDataSourceJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.MultiDataSourceJPA.dao.ProductDAO;
import com.MultiDataSourceJPA.dao2.ProductDAO2;
import com.MultiDataSourceJPA.entity.Product;
import com.MultiDataSourceJPA.entity2.ProductSecond;

@SpringBootApplication
(exclude= {DataSourceAutoConfiguration.class ,
		                         JdbcTemplateAutoConfiguration.class
})
public class MultiDataSourceJpaApplication implements CommandLineRunner{
@Autowired
ProductDAO productDAO;

@Autowired
ProductDAO2 productDAO2;
	
	public static void main(String[] args) {
		SpringApplication.run(MultiDataSourceJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product=new Product(102 , "bottle" , "200");
		productDAO.save(product);
		
		ProductSecond product2=new ProductSecond(102 , "bottle" , "200");
		productDAO2.save(product2);
		
		System.out.println("Records are insterted Successfully............");
	}

}
