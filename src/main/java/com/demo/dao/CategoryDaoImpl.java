package com.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			//con=DBUtil.getMyConnection();
			inspr1=con.prepareStatement("select cid from category where name=?");
		}	
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public int selectId(String name)
	{
		int id=0;
	    try 
	    {
	    	inspr1.setString(1, name);
			ResultSet rs=inspr1.executeQuery();
			while(rs.next()) {
			id=rs.getInt(1);
			System.out.println(id);
			}
		} 
	    catch (SQLException e)
	    {
			e.printStackTrace();
		}
	    return(id);
	}
}
