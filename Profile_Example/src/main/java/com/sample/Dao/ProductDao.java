package com.sample.Dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.entites.Product;

public interface ProductDao {
  public List<Product> getProducts() throws ClassNotFoundException, SQLException;
}
