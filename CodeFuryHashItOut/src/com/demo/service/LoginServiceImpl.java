package com.demo.service;
import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService
{
	 LoginDao loginDao;
	public LoginServiceImpl() {
		super();
		loginDao=new LoginDaoImpl();
	}
	@Override
	public int validateUser(String uname, String pass) {
		return (loginDao.checkCredentials(uname,pass));
		
	}
}
