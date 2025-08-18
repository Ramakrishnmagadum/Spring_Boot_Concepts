package com.MultiDataSourceJPA.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //# This will enable the Transaction Management ......
@EnableJpaRepositories(basePackages="com.MultiDataSourceJPA.dao"  //# this will scan Dao Layer and Provide the Implementations for DAO Object ---Like it will give the implementations for the CRUD Methods..
                      , entityManagerFactoryRef="postgresentityManagerFactoryBean", //By Default Spring Create EntityManagerFactoryBean Object with name "entityManager" but we are customizing that object and changing object name also that's why we need to explicitly mmention the Object name..
                       transactionManagerRef="postgrestransactionManager"   //By Default Spring Create TransactionManager Object with name "transactionManager" but we are customizing that object and changing object name also that's why we need to explicitly mmention the Object name..
                       )    
public class PostgresSqlConfig {
	
//	----------------------------------------------------------------------------------------------------------------------------------
//	This Both Objects are creating because to get  "EntityManagerFactoryBuilder"  object ,used this object for build the connection...in future..
	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(true);       // allows Hibernate to create/update schema
        adapter.setShowSql(true);           // shows SQL queries in logs
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect"); // or MySQLDialect, etc.
        return adapter;
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(
            JpaVendorAdapter jpaVendorAdapter,
            ObjectProvider<PersistenceUnitManager> persistenceUnitManager) {
        return new EntityManagerFactoryBuilder(
                jpaVendorAdapter,
                new HashMap<>(),
                persistenceUnitManager.getIfAvailable()
        );
    }
//	----------------------------------------------------------------------------------------------------------------------------------
	

	@Bean("postgresdataSourceProperties") //# Customizing the Bean bcz in multidatabase connection ---Multiple Objects needed so.....
//	@ConfigurationProperties is a Spring Boot annotation that is used to bind externalized configuration (from application.properties or application.yml) to a Java class in a strongly typed manner.
//	Here DataSourceProperties Object will store  DB Related Information----like (username , password , url and so on )
//	it will check in application.properties file with start with "spring.datasource.postgres" 
//	Example: spring.datasource.postgres.username ---this will set for "Username" like that it will store DB Information and 
//	with This DB Information will create DataSource Object............
	@ConfigurationProperties(prefix="spring.datasource.postgres")  //
    DataSourceProperties postgresdataSourceProperties() {
		return new DataSourceProperties();
	}
	

	@Bean("postgresDataSource") //# This will create DataSource Object for "spring.datasource.postgres.*"
	DataSource dataSource() {
//		DriverManagerDataSource datasource =new DriverManagerDataSource();
//		datasource.setDriverClassName(dataSourceProperties().getDriverClassName());
//		datasource.setUsername(dataSourceProperties().getUsername());
//		datasource.setPassword(dataSourceProperties().getPassword());
//		datasource.setUrl(dataSourceProperties().getUrl());
//		return datasource;
		return postgresdataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean(name ="postgresentityManagerFactoryBean") //#With this DataSource Object it will Create EntityManagerFacotryBean ---> and this will helps in building the DataBase Connection...
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder ManagerFactoryBuilder , @Qualifier("postgresDataSource") DataSource dataSource ) {
		return ManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.MultiDataSourceJPA.entity") 
                .build();
	}
	
	
	@Bean(name="postgrestransactionManager") //#This Will Manage the Trasacntion for this BD Connection....
	PlatformTransactionManager transactionManager(@Qualifier("postgresentityManagerFactoryBean")LocalContainerEntityManagerFactoryBean entityManagerFactoryBean ) {
		JpaTransactionManager jpaTransactionManager =new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
		return jpaTransactionManager;
	}
	
	
//	----------------------IMP--------------------
//	By Following this Above Step ---we can create Database Connection for how much DB Connection we want.............
//	Just we need to follow the same steps with object names need to give different ....
	
}
