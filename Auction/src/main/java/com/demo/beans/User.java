package com.demo.beans;

import java.util.Date;

public class User 
{
private String name;
private String userID;
private String username;
private String password;
private int phoneNumber;
private String email;
private Date dateOfBirth;
private int walletAmount;
private String typeOfUser;
private String address;
public User() {
	super();
	this.name = null;
	this.userID = null;
	this.username = null;
	this.password = null;
	this.phoneNumber = 0;
	this.email = email;
	this.dateOfBirth = null;
	this.walletAmount = 0;
	this.typeOfUser = null;
	this.address = null;
	
}
public User(String name, String userID, String username, String password, int phoneNumber, String email,
		Date dateOfBirth, int walletAmount, String typeOfUser, String address) {
	super();
	this.name = name;
	this.userID = userID;
	this.username = username;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.dateOfBirth = dateOfBirth;
	this.walletAmount = walletAmount;
	this.typeOfUser = typeOfUser;
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public int getWalletAmount() {
	return walletAmount;
}
public void setWalletAmount(int walletAmount) {
	this.walletAmount = walletAmount;
}
public String getTypeOfUser() {
	return typeOfUser;
}
public void setTypeOfUser(String typeOfUser) {
	this.typeOfUser = typeOfUser;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "User [name=" + name + ", userID=" + userID + ", username=" + username + ", password=" + password
			+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", walletAmount="
			+ walletAmount + ", typeOfUser=" + typeOfUser + ", address=" + address + "]";
}



}
