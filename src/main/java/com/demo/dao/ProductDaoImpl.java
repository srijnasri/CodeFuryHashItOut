package com.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao
{
	static Connection con;
    static PreparedStatement pgetAllProd,inspr;
    static 
    {
    	con=DBUtil.getMyConnection();
    	try
    	{	
			pgetAllProd=con.prepareStatement("select * from Product");
			inspr=con.prepareStatement("insert into Product values(?,?,?,?,?,?,?)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }	
	@Override
	public List<Product> findAllProducts() {
		try {
			List<Product> plist=new ArrayList<>();
			ResultSet rs=pgetAllProd.executeQuery();
			while(rs.next())
			{
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7)));
			}
			return plist;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void save(Product p)
	{
		try {
			 inspr.setNull(1,Types.INTEGER);
			 inspr.setString(2, p.getName());
			 inspr.setInt(3, p.getCid());
			 inspr.setString(4, p.getDescription());
			 inspr.setDouble(5, p.getActualPrice());
			 inspr.setInt(6, p.getQuantity());
			 inspr.setString(7,p.getImage());
			
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
		}
		
	}
}
