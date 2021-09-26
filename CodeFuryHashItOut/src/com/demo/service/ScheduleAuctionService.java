package com.demo.service;

import java.util.List;

import com.demo.beans.Bid;
import com.demo.beans.Product;
import com.demo.beans.User;

public interface ScheduleAuctionService {
	List<Product> getSellerProducts(int sellerId);
}
