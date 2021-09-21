package com.demo.service;

import com.demo.dao.CategoryDao;
import com.demo.dao.CategoryDaoImpl;

public class CategoryServiceImpl implements CategoryService{
	CategoryService cservice=new CategoryServiceImpl();
	CategoryDao cdao;
	public CategoryServiceImpl()
	{
		super();
		this.cdao = new CategoryDaoImpl();
	}
	
	@Override
	public int selectCategory(String name) 
	{
		int categoryID=cdao.selectId(name);
		return(categoryID);
	}
	
}
