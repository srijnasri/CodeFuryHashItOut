package com.demo.beans;

public class Product
{
private int pid;
private String name;
private int quantity;
private int sellerid;
private int cid;
private double actualPrice;
private String description;
private String image;
public Product() {
	super();
	
}


public Product(String name, String image) {
	super();
	this.name = name;
	this.image = image;
}


public Product(String name, String image, double actualPrice, int quantity) {
	super();
	this.name = name;
	this.quantity = quantity;
	this.actualPrice = actualPrice;
	this.image = image;
}


public Product(int pid, String name, int quantity, int sellerID, int cid, double actualPrice, String description,
		String image) {
	super();
	this.pid = pid;
	this.name = name;
	this.quantity = quantity;
	this.sellerid = sellerID;
	this.cid = cid;
	this.actualPrice = actualPrice;
	this.description = description;
	this.image = image;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getSellerID() {
	return sellerid;
}
public void setSellerID(int sellerID) {
	this.sellerid = sellerID;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public double getActualPrice() {
	return actualPrice;
}
public void setActualPrice(double actualPrice) {
	this.actualPrice = actualPrice;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", name=" + name + ", quantity=" + quantity + ", sellerID=" + sellerid + ", cid="
			+ cid + ", actualPrice=" + actualPrice + ", description=" + description + ", image=" + image + "]";
}


}