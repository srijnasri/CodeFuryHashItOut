package com.demo.beans;

import java.util.Date;

public class User 
{
private String username;
private int userid;
private String name;
private String password;
private String phoneno;
private String emailid;
private Date dob;
private double walletamount;
private String typeOfUser;
private String address;
public User() {
	super();
	this.username = null;
	this.userid = 0;
	this.name = null;
	this.password = null;
	this.phoneno = null;
	this.emailid = null;
	this.dob = null;
	this.walletamount = 0.0;
	this.typeOfUser = null;
	this.address = null;
}


public User(String username, String name, String password, String phoneno, String emailid, Date dob,
		double walletamount, String typeOfUser, String address) {
	super();
	this.username = username;
	this.userid = userid;
	this.name = name;
	this.password = password;
	this.phoneno = phoneno;
	this.emailid = emailid;
	this.dob = dob;
	this.walletamount = walletamount;
	this.typeOfUser = typeOfUser;
	this.address = address;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public double getWalletamount() {
	return walletamount;
}
public void setWalletamount(double walletamount) {
	this.walletamount = walletamount;
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
	return "User [username=" + username + ", userid=" + userid + ", name=" + name + ", password=" + password
			+ ", phoneno=" + phoneno + ", emailid=" + emailid + ", dob=" + dob + ", walletamount=" + walletamount
			+ ", typeOfUser=" + typeOfUser + ", address=" + address + "]";
}
}