package com.demo.beans;

public class Bid 
{
private String bidID;
private String buyerID;
private String productID;
private int bidValue;
private String Status;
public Bid() {
	super();
	this.bidID = null;
	this.buyerID = null;
	this.productID = null;
	this.bidValue = 0;
	Status = null;
}
public Bid(String bidID, String buyerID, String productID, int bidValue, String status) {
	super();
	this.bidID = bidID;
	this.buyerID = buyerID;
	this.productID = productID;
	this.bidValue = bidValue;
	Status = status;
}

public String getBidID() {
	return bidID;
}
public void setBidID(String bidID) {
	this.bidID = bidID;
}
public String getBuyerID() {
	return buyerID;
}
public void setBuyerID(String buyerID) {
	this.buyerID = buyerID;
}
public String getProductID() {
	return productID;
}
public void setProductID(String productID) {
	this.productID = productID;
}
public int getBidValue() {
	return bidValue;
}
public void setBidValue(int bidValue) {
	this.bidValue = bidValue;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
@Override
public String toString() {
	return "Bid [bidID=" + bidID + ", buyerID=" + buyerID + ", productID=" + productID + ", bidValue=" + bidValue
			+ ", Status=" + Status + "]";
}

}
