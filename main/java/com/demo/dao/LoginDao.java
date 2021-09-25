package com.demo.dao;
import com.demo.beans.User;

public interface LoginDao 
{
	User checkCredentials(String uname, String pass);
}
