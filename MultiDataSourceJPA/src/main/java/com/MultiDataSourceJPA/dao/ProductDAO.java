package com.MultiDataSourceJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MultiDataSourceJPA.entity.Product;

public interface ProductDAO  extends JpaRepository<Product, Integer>{

}
