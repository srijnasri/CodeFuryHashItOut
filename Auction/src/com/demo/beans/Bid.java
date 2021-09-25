package com.demo.beans;

public class Bid 
{
private int bidid;
private int buyerid;
private int pid;
private double bidValue;
private int quantity;
private String Status;
public Bid() {
	super();
	this.bidid = 0;
	this.buyerid = 0;
	this.pid = 0;
	this.bidValue = 0.0;
	Status = null;
	
}

public Bid(int buyerid, int pid, double bidValue, int quantity,String status) {
	super();
	this.buyerid = buyerid;
	this.pid = pid;
	this.bidValue = bidValue;
	Status = status;
}



public Bid(int bidid, int buyerid, int pid, double bidValue, int quantity, String status) {
	super();
	this.bidid = bidid;
	this.buyerid = buyerid;
	this.pid = pid;
	this.bidValue = bidValue;
	this.quantity = quantity;
	Status = status;
}

public int getBidid() {
	return bidid;
}

public void setBidid(int bidid) {
	this.bidid = bidid;
}

public int getBuyerid() {
	return buyerid;
}

public void setBuyerid(int buyerid) {
	this.buyerid = buyerid;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public double getBidValue() {
	return bidValue;
}

public void setBidValue(double bidValue) {
	this.bidValue = bidValue;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

@Override
public String toString() {
	return "Bid [bidid=" + bidid + ", buyerid=" + buyerid + ", pid=" + pid + ", bidValue=" + bidValue
			+ ", Status=" + Status + "]";
}


}