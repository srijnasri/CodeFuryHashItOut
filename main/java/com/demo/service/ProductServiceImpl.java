package com.demo.service;
import java.util.List;
import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService
{
	ProductDao pdao;
	public ProductServiceImpl()
	{
		super();
		this.pdao = new ProductDaoImpl();
	}
	@Override
	public List<Product> getAllProducts() 
	{
		return pdao.findAllProducts();
	}
	@Override
	public void addProduct(Product p) 
	{
		       pdao.save(p);		
	}
}
