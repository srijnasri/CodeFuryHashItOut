package com.demo.service;
import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.Product;

public interface ProductService
{
	List<Product> getAllProducts(int userid);
	void addProduct(Product p);
}
