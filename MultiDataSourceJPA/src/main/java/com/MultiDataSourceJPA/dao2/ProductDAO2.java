package com.MultiDataSourceJPA.dao2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MultiDataSourceJPA.entity2.ProductSecond;


public interface ProductDAO2  extends JpaRepository<ProductSecond, Integer>{

}
