package com.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.Product;

public class CategoryDaoImpl implements CategoryDao
{
	static Connection con;
	static PreparedStatement inspr1;
	static 
	   {
		con=DBUtil.getMyConnection();
		try 
		{
			inspr1=con.prepareStatement("select cid from categorty where name=?");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	  }
	@Override
	public int selectId(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	
		

}
