package com.demo.dao;

import java.util.List;

import com.demo.beans.Bid;
import com.demo.beans.Product;

public interface BuyerDao {
	
	List<Product> boughtProducts(int buyerid);
	List<List<String>> auctionProducts(int buyerid);
	public void addBid(int buyerid, Bid bid);
}
