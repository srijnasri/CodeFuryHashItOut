package com.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import com.demo.beans.Product;

public interface ProductDao
{
	List<Product> findAllProducts();
	void save(Product p);

}
