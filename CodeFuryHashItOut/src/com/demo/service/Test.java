package com.demo.service;

import com.demo.dao.CategoryDaoImpl;
import com.demo.service.CategoryServiceImpl;

public class Test
{
public static void main(String [] args)
{
	CategoryDaoImpl c= new CategoryDaoImpl();
	int k=c.selectId("furniture");
	System.out.println(k);
}
}
