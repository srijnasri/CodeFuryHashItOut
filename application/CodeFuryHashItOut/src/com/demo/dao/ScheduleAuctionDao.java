package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ScheduleAuctionDao {
	List<Product> getAllSellerProducts(int sellerId);
}
