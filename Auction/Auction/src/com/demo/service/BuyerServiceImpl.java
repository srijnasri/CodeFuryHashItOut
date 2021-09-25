package com.demo.service;

import java.util.List;

import com.demo.beans.Bid;
import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.dao.BuyerDao;
import com.demo.dao.BuyerDaoImpl;

public class BuyerServiceImpl implements BuyerService {

	BuyerDao b;
	public BuyerServiceImpl() {
		super();
		b=new BuyerDaoImpl();
	}

	@Override
	public List<Product> allboughtProducts(int buyerid) {
		return b.boughtProducts(buyerid);
	}

	@Override
	public List<List<String>> allauctionProducts(int buyerid) {
		return b.auctionProducts(buyerid);
	}

	@Override
	public void putBid(int buyerid, Bid bid) {
		b.addBid(buyerid,bid);
		
	}

}
