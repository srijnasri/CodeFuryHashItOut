package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ScheduleAuctionDaoImpl implements ScheduleAuctionDao{
	static Connection con;
    static PreparedStatement getSellerProducts;
	static 
    {
    	con=DBUtil.getMyConnection();
    	try
    	{	
			getSellerProducts = con.prepareStatement("SELECT pid,name,quantity,sellerID,cid,actualPrice,description,image from product where sellerid = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	@Override
	public List<Product> getAllSellerProducts(int sellerId) {
		List<Product> productList = new ArrayList<Product>();
		try {
			getSellerProducts.setInt(1,sellerId);
			ResultSet rs = getSellerProducts.executeQuery();
			while(rs.next())
			{
				productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(6), rs.getInt(8), rs.getInt(3), rs.getDouble(5), rs.getString(4),
						rs.getString(7)));
			}
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

}
