package com.demo.beans;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.dao.DBUtil;

public class AuctionCloser implements Runnable {

	@Override
	public void run() {
		Connection con= DBUtil.getMyConnection();  
        try{
        	
        	
        	String endQuery = "Select pid,sellerid from productauction where bidenddate = CURDATE()";
        	String updateStatusQuery = "Update productauction SET status = ?,buyerid= ?,soldprice=? where bidenddate = CURDATE()";
        	String upadateQuantityQuery = "Update product SET quantity = ? where pid = ?";
        	String updateWalletAmountQuery = "Update user set walletamount = ? where userid = ?";
        	String updateBidQuery = "Update bid set status = ? where bidid = ?";
        	int wonBuyer=0;
        	double soldprice=0.0;
            PreparedStatement ps = con.prepareStatement(endQuery);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int productId = rs.getInt(1);
                int sellerId = rs.getInt(2);
                System.out.println(productId);
                PreparedStatement getBids = con.prepareStatement("Select buyerid,bidvalue,bidquantity,bidid from bid where pid = ? order by bidvalue desc");
                getBids.setInt(1, productId);
                ResultSet bids = getBids.executeQuery();
                boolean updateFlag = false;
                boolean alreadyWon = false;
                while(bids.next()) {
                    int buyerId = bids.getInt(1);
                    double bidValue = bids.getDouble(2); 
                    int productQuantity = bids.getInt(3);
                    int bidid = bids.getInt(4);
                    PreparedStatement getWalletAmount = con.prepareStatement("Select walletamount from user where userid = ?");
                    getWalletAmount.setInt(1, buyerId);
                    ResultSet walletAmount = getWalletAmount.executeQuery();
                    double wAmount = 0;
                    while(walletAmount.next())
                    {
                    	 wAmount = walletAmount.getDouble(1);
                    }
                    getWalletAmount.setInt(1, sellerId);
                    ResultSet sellerwalletAmount = getWalletAmount.executeQuery();
                    double sAmount = 0;
                    while(sellerwalletAmount.next())
                    {
                    	 sAmount = sellerwalletAmount.getDouble(1);
                    }
                    
                    System.out.println(wAmount);
                    if((bidValue*productQuantity)<=wAmount && alreadyWon==false)
                    {
                    	wonBuyer=buyerId;
                    	soldprice=bidValue;
                        wAmount=wAmount-(bidValue*productQuantity);
                        PreparedStatement updateQ = con.prepareStatement(upadateQuantityQuery);
                        PreparedStatement getCurrentProductQ = con.prepareStatement("Select quantity from product where pid = ?");
                        getCurrentProductQ.setInt(1, productId);
                        ResultSet currentQ  = getCurrentProductQ.executeQuery();
                        int currentproductQuantity = 0;
                        while(currentQ.next())
                        {
                        	currentproductQuantity = currentQ.getInt(1);
                        }
                        currentproductQuantity = currentproductQuantity - productQuantity;
                        updateQ.setInt(1,currentproductQuantity);
                        updateQ.setInt(2,productId);
                        int i = updateQ.executeUpdate();
                        if(i>0) {
                        	con.commit();
                            System.out.println("Update succeded!");
                        }
                        else{
                            System.out.println("Update failed!");
                        }
                        double buyerWalletAmount = wAmount - bidValue*productQuantity;
                        double sellerWalletAmount = sAmount + bidValue*productQuantity;
                        PreparedStatement uwa = con.prepareStatement(updateWalletAmountQuery);
                        uwa.setDouble(1,buyerWalletAmount);
                        uwa.setInt(2,buyerId);
                        i=uwa.executeUpdate();
                        if (i>0)
                        	con.commit();
                        uwa.setDouble(1,sellerWalletAmount);
                        uwa.setInt(2,sellerId);
                        i=uwa.executeUpdate();
                        if (i>0)
                        	con.commit();
                        updateFlag = true;
                        PreparedStatement updatebid = con.prepareStatement(updateBidQuery);
                        updatebid.setString(1,"won");
                        updatebid.setInt(2,bidid);
                        i=updatebid.executeUpdate();
                        alreadyWon=true;
                        if (i>0)
                        	con.commit();
                    }
                    else
                    {
                    	PreparedStatement updatebid = con.prepareStatement(updateBidQuery);
                        updatebid.setString(1,"lost");
                        updatebid.setInt(2,bidid);
                        int i=updatebid.executeUpdate();
                        if (i>0)
                        	con.commit();
                        
                    }
                }
               
                if(updateFlag==true)
                {
                    PreparedStatement updateStatus = con.prepareStatement(updateStatusQuery);
                    updateStatus.setString(1,"sold");
                    updateStatus.setInt(2,wonBuyer);
                    updateStatus.setDouble(3,soldprice);
                    int i=updateStatus.executeUpdate();
                    if (i>0)
                    	con.commit();
                    
                }
                else
                {
                    PreparedStatement updateStatus = con.prepareStatement(updateStatusQuery);
                    updateStatus.setString(1,"not sold");
                    int i=updateStatus.executeUpdate();
                    if (i>0)
                    	con.commit();
                }
            }   
        }
        catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
        catch(Exception e)
        {
        	System.out.println(e);
        }
        System.out.println("Hello");
	}
}