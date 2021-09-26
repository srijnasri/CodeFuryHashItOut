package com.demo.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuctionStarter implements Runnable {

    @Override
    public void run() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");  
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineauctiondb","root","root");
        	String getAllProducts = "update productauction set status = ? where status = ? and bidstartdate = CURDATE()";
        	PreparedStatement getProducts = con.prepareStatement(getAllProducts);
        	getProducts.setString(1,"Open");
        	getProducts.setString(2,"New");
        	int i = getProducts.executeUpdate();
             if(i>0) {
             	con.commit();
                 System.out.println("Update succeded :)");
             }
             else
             {
            	 System.out.println("Update failed :(");
             }
        	
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
        	System.out.println(e);
        }
        System.out.println("Hello");
    }

}