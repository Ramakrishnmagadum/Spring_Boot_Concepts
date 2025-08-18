package com.MultiDataSourceJPA.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//Same Steps followed as previous with Object names are different................
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages="com.MultiDataSourceJPA.dao2",
                       entityManagerFactoryRef="secondentityManagerFactoryBean",
                       transactionManagerRef="secondtransactionManager"
                       )    
public class SecondPostgresSqlConfig {
	
	@Bean("seconddataSourceProperties")
	@ConfigurationProperties(prefix="spring.datasource.second")
    DataSourceProperties seconddataSourceProperties() {
		return new DataSourceProperties();
	}
	

	@Bean("secondDataSource")
	DataSource dataSource() {
//		DriverManagerDataSource datasource =new DriverManagerDataSource();
//		datasource.setDriverClassName(dataSourceProperties().getDriverClassName());
//		datasource.setUsername(dataSourceProperties().getUsername());
//		datasource.setPassword(dataSourceProperties().getPassword());
//		datasource.setUrl(dataSourceProperties().getUrl());
//		return datasource;
		return seconddataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean(name ="secondentityManagerFactoryBean")
	LocalContainerEntityManagerFactoryBean secondentityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder , @Qualifier("secondDataSource") DataSource dataSource ) {
		return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.MultiDataSourceJPA.entity2") 
                .build();
	}
	
	
	@Bean(name="secondtransactionManager")
	PlatformTransactionManager transactionManager(@Qualifier("secondentityManagerFactoryBean")LocalContainerEntityManagerFactoryBean entityManagerFactoryBean ) {
		JpaTransactionManager jpaTransactionManager =new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
		return jpaTransactionManager;
	}
	
	
}
