package com.demo.beans;

import java.util.Date;

public class ProductAuction 
{
private int auctionid;
private int pid;
private int sellerid;
private double minbidvalue;
private Date bidstartdate;
private Date bidenddate;
private int buyerid;
private double soldprice;
private String status;
public ProductAuction() {
	super();
	this.auctionid = 0;
	this.pid = 0;
	this.sellerid = 0;
	this.minbidvalue = 0.0;
	this.bidstartdate = null;
	this.bidenddate = null;
	this.buyerid = 0;
	this.soldprice = 0.0;
	this.status = null;
	
}
public ProductAuction(int auctionid, int pid, int sellerid, double minbidvalue, Date bidstartdate, Date bidenddate,
		int buyerid, double soldprice, String status) {
	super();
	this.auctionid = auctionid;
	this.pid = pid;
	this.sellerid = sellerid;
	this.minbidvalue = minbidvalue;
	this.bidstartdate = bidstartdate;
	this.bidenddate = bidenddate;
	this.buyerid = buyerid;
	this.soldprice = soldprice;
	this.status = status;
}
public int getAuctionid() {
	return auctionid;
}
public void setAuctionid(int auctionid) {
	this.auctionid = auctionid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getSellerid() {
	return sellerid;
}
public void setSellerid(int sellerid) {
	this.sellerid = sellerid;
}
public double getMinbidvalue() {
	return minbidvalue;
}
public void setMinbidvalue(double minbidvalue) {
	this.minbidvalue = minbidvalue;
}
public Date getBidstartdate() {
	return bidstartdate;
}
public void setBidstartdate(Date bidstartdate) {
	this.bidstartdate = bidstartdate;
}
public Date getBidenddate() {
	return bidenddate;
}
public void setBidenddate(Date bidenddate) {
	this.bidenddate = bidenddate;
}
public int getBuyerid() {
	return buyerid;
}
public void setBuyerid(int buyerid) {
	this.buyerid = buyerid;
}
public double getSoldprice() {
	return soldprice;
}
public void setSoldprice(double soldprice) {
	this.soldprice = soldprice;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "ProductAuction [auctionid=" + auctionid + ", pid=" + pid + ", sellerid=" + sellerid + ", minbidvalue="
			+ minbidvalue + ", bidstartdate=" + bidstartdate + ", bidenddate=" + bidenddate + ", buyerid=" + buyerid
			+ ", soldprice=" + soldprice + ", status=" + status + "]";
}

}
