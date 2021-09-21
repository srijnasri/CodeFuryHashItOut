package com.demo.beans;
import java.util.Date;

public class Product
{
private int pid;
private String name;
private int cid;
private String description;
private double actualPrice;
private int quantity;
private String image;
private int sellerid;

public Product() {
	super();
	
}

public Product(int pid, String name, int cid, String description, double actualPrice, int quantity, String image,
		int sellerid) {
	super();
	this.pid = pid;
	this.name = name;
	this.cid = cid;
	this.description = description;
	this.actualPrice = actualPrice;
	this.quantity = quantity;
	this.image = image;
	this.sellerid = sellerid;
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
