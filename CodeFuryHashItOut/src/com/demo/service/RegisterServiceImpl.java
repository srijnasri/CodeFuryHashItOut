package com.demo.service;
import com.demo.beans.User;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.dao.RegisterDao;
import com.demo.dao.RegisterDaoImpl;

public class RegisterServiceImpl implements RegisterService
{
	RegisterDao rdao;
	public RegisterServiceImpl()
	{
		super();
		this.rdao = new RegisterDaoImpl();
	}
	@Override
	public void addUser(User u) 
	{
		rdao.addUserdb(u);
	}
}
