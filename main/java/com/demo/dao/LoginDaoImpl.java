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
			pselect=con.prepareStatement("select * from user where username=? and password=?");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public User checkCredentials(String username, String password) {
		try {
			pselect.setString(1, username);pselect.setString(2, password);
			ResultSet rs=pselect.executeQuery();
			if(rs.next()) {
				String uname=rs.getString(6);
				String pss=rs.getString(7);
				if((rs.getString(6).equals(username)) && (rs.getString(7).equals(password)))
				{
					return new User(rs.getInt(1),rs.getString(2), rs.getDate(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDouble(9),rs.getString(10));
				}
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
