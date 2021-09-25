package com.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import com.demo.beans.User;

public class RegisterDaoImpl implements RegisterDao
{
	static Connection con;
    static PreparedStatement inspr;
    static 
    {
    	con=DBUtil.getMyConnection();
    	try
    	{	
			inspr=con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }	
	@Override
	public void addUserdb(User u) 
	{
		try 
		{
			 inspr.setNull(1,Types.INTEGER);
			 inspr.setString(2, u.getName());
			 java.sql.Date sdat=new java.sql.Date(u.getDob().getTime());
			 inspr.setDate(3, sdat);
			 inspr.setString(4, u.getEmailid());
			 inspr.setString(5,u.getPhoneno());
			 inspr.setString(6, u.getUsername());
			 inspr.setString(7, u.getPassword());
			 inspr.setString(8, u.getAddress());
			 inspr.setDouble(9,u.getWalletamount());
			 inspr.setString(10, u.getTypeOfUser());
			 int num=inspr.executeUpdate();	 
			 if(num>0)
			 {
				 con.commit();
			 }
		 	
		    }
		    catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1)
			{	
				e1.printStackTrace();
			}
			System.out.println("Registered");
		}
	}
}