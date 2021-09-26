package com.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao{
	static Connection con;
	static PreparedStatement pselect;
	static 
	   {
		con=DBUtil.getMyConnection();
		try 
		{
			pselect=con.prepareStatement("select userid,typeofuser from user where username=? and password=?");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public int checkCredentials(String username, String password) {
		
		try {
			pselect.setString(1, username);pselect.setString(2, password);
			ResultSet rs=pselect.executeQuery();
			String userid=null;
			if(rs.next()) {
				userid=rs.getString(1);
				String typeofuser=rs.getString(2);
				if(userid=="")
				{
					return -1;
				}
				else
					return Integer.parseInt(userid);
			}
			
			}
			
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}

}
