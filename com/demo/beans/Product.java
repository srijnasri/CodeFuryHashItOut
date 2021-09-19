package com.demo.beans;
import java.util.Date;

public class Product
{
private String productId;
private String productName;
private int quantity;
private String sellerID;
private String categoryId;
private String buyerID;
private int soldPrice;
private String status;
private int actualPrice;
private String description;
private Date bidEndDate;
private Date bidStartDate;
private int minimumBidValue;
private String image;
public Product() {
	super();
	this.productId = null;
	this.productName = null;
	this.quantity = 0;
	this.sellerID = null;
	this.categoryId = null;
	this.buyerID = null;
	this.soldPrice = 0;
	this.status = null;
	this.actualPrice = 0;
	this.description = null;
	this.bidEndDate = null;
	this.bidStartDate = null;
	this.minimumBidValue = 0;
	this.image = null;
}
public Product(String productId, String productName, int quantity, String sellerID, String categoryId, String buyerID,
		int soldPrice, String status, int actualPrice, String description, Date bidEndDate, Date bidStartDate,
		int minimumBidValue, String image) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.quantity = quantity;
	this.sellerID = sellerID;
	this.categoryId = categoryId;
	this.buyerID = buyerID;
	this.soldPrice = soldPrice;
	this.status = status;
	this.actualPrice = actualPrice;
	this.description = description;
	this.bidEndDate = bidEndDate;
	this.bidStartDate = bidStartDate;
	this.minimumBidValue = minimumBidValue;
	this.image = image;
}

public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getSellerID() {
	return sellerID;
}
public void setSellerID(String sellerID) {
	this.sellerID = sellerID;
}
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getBuyerID() {
	return buyerID;
}
public void setBuyerID(String buyerID) {
	this.buyerID = buyerID;
}
public int getSoldPrice() {
	return soldPrice;
}
public void setSoldPrice(int soldPrice) {
	this.soldPrice = soldPrice;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getActualPrice() {
	return actualPrice;
}
public void setActualPrice(int actualPrice) {
	this.actualPrice = actualPrice;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getBidEndDate() {
	return bidEndDate;
}
public void setBidEndDate(Date bidEndDate) {
	this.bidEndDate = bidEndDate;
}
public Date getBidStartDate() {
	return bidStartDate;
}
public void setBidStartDate(Date bidStartDate) {
	this.bidStartDate = bidStartDate;
}
public int getMinimumBidValue() {
	return minimumBidValue;
}
public void setMinimumBidValue(int minimumBidValue) {
	this.minimumBidValue = minimumBidValue;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity + ", sellerID="
			+ sellerID + ", categoryId=" + categoryId + ", buyerID=" + buyerID + ", soldPrice=" + soldPrice
			+ ", status=" + status + ", actualPrice=" + actualPrice + ", description=" + description + ", bidEndDate="
			+ bidEndDate + ", bidStartDate=" + bidStartDate + ", minimumBidValue=" + minimumBidValue + ", image="
			+ image + "]";
}

}
