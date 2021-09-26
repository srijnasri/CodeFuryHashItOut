package com.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import java.sql.*;

import com.demo.beans.Bid;
import com.demo.beans.Product;

public class BuyerDaoImpl implements BuyerDao {
	
	static Connection con;
    static PreparedStatement getp,getauctionp,addb,getbidders;
  
    static 
    {
    	con=DBUtil.getMyConnection();
    	try
    	{	
			getp=con.prepareStatement("select name,image from product where pid in"
					+ "(select pid from bid where buyerid=? and status='won')");
			getauctionp=con.prepareStatement("select productauction.pid,name,image,minbidvalue,quantity,bidenddate from product inner join productAuction"
					+ " where product.pid=productAuction.pid AND Status='open'and productauction.pid not in(select distinct pid from bid where buyerid=?)");
			
			addb=con.prepareStatement("insert into bid(buyerid,pid,bidvalue,bidquantity,status) values(?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }	

	@Override
	public List<Product> boughtProducts(int buyerid) {
		try {
			getp.setInt(1, buyerid);
			List<Product> plist=new ArrayList<>();
			ResultSet rs=getp.executeQuery();
			while(rs.next())
			{
				plist.add(new Product(rs.getString(1),rs.getString(2)));
			}
			return plist;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<List<String>> auctionProducts(int buyerid) {
		try {
			List<List<String>> alist=new ArrayList<List<String>>();
			getauctionp.setInt(1, buyerid);
			ResultSet rs=getauctionp.executeQuery();
			while(rs.next())
			{
				List<String> list=new ArrayList<String>();
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				getbidders=con.prepareStatement("Select count(bidid) from bid where status='open' and pid="+rs.getString(1)+"");
				ResultSet rs1=getbidders.executeQuery();
				while(rs1.next())
				list.add(rs1.getString(1));
				alist.add(list);
			}
			return alist;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addBid(int buyerid, Bid bid) {
		try {
			 addb.setInt(1,buyerid);
			 addb.setInt(2, bid.getPid());
			 addb.setDouble(3,bid.getBidValue());
			 addb.setInt(4,bid.getQuantity());
			 addb.setString(5, bid.getStatus());
			 int x=addb.executeUpdate();
			 
			 if(x>0)
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
