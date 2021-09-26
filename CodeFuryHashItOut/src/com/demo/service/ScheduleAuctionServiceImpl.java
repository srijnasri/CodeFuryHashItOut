package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ScheduleAuctionDao;
import com.demo.dao.ScheduleAuctionDaoImpl;

public class ScheduleAuctionServiceImpl implements ScheduleAuctionService{
	ScheduleAuctionDao sad;
	
	
	public ScheduleAuctionServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		sad = new ScheduleAuctionDaoImpl();
	}


	@Override
	public List<Product> getSellerProducts(int sellerId) {
		return sad.getAllSellerProducts(sellerId);
	}
	
}
