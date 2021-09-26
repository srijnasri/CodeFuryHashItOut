package com.demo.dao;
import com.demo.beans.User;

public interface LoginDao 
{
	int checkCredentials(String uname, String pass);
}
