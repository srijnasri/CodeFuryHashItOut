package com.demo.service;

import java.util.List;

import com.demo.beans.Bid;
import com.demo.beans.Product;
import com.demo.beans.User;

public interface BuyerService {
	List<Product> allboughtProducts(int buyerid);
	List<List<String>> allauctionProducts(int buyerid);
	public void putBid(int buyerid, Bid bid);
}
