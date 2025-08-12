package com.springdataJPA.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages="com")
@Configuration
@EnableTransactionManagement
public class AppConfig {

//	# This will create DataSource Object and with this information it will help to connect the Database .
	@Bean
	DriverManagerDataSource dataSource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUrl("jdbc:postgresql://localhost:5432/StudentManagement");
		datasource.setDriverClassName("org.postgresql.Driver");
		datasource.setUsername("postgres");
		datasource.setPassword("postgres123");
		return datasource;
	}
	
//	# This is EntityManagerFactoryBean ---This will build the connection with DB
//	Scan all the Entity Class and Map It with Java to DabaBase...
//	JPA is just Specifications But for this specification we  need Provider --Here Implementation provider is Hibernate...
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.springdataJPA.entity");//# Tells Spring to scan this package for JPA entity classes (@Entity annotated classes).
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());//# Tells Spring which JPA implementation to use — here, it's Hibernate.
		return entityManagerFactoryBean;
	}
	
//	# This will make this CRUD Operations --->  will managed by TransactionManager 
//	To enable this TransactionManager will use "@EnableTransactionManagement" Annotation on top of the class...
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTransactionManager=new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		return 	jpaTransactionManager;
	}
	
}
