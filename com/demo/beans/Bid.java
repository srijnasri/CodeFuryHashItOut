package com.demo.beans;

public class Bid 
{
private int bidid;
private String name;
private int buyerid;
private int pid;
private double bidValue;
private String Status;
public Bid() {
	super();
	this.bidid = 0;
	this.name = null;
	this.buyerid = 0;
	this.pid = 0;
	this.bidValue = 0.0;
	Status = null;
	
}
public Bid(int bidid, String name, int buyerid, int pid, double bidValue, String status) {
	super();
	this.bidid = bidid;
	this.name = name;
	this.buyerid = buyerid;
	this.pid = pid;
	this.bidValue = bidValue;
	Status = status;
}
public int getBidid() {
	return bidid;
}
public void setBidid(int bidid) {
	this.bidid = bidid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
@Override
public String toString() {
	return "Bid [bidid=" + bidid + ", name=" + name + ", buyerid=" + buyerid + ", pid=" + pid + ", bidValue=" + bidValue
			+ ", Status=" + Status + "]";
}


}
