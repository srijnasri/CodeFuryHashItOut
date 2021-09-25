package com.demo.beans;

import java.util.Date;

public class User 
{
private int userid;
private String name;
private Date dob;
private String emailid;
private String phoneno;
private String username;
private String password;
private String address;
private double walletamount;
private String typeOfUser;

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

public User(int userid, String name, Date dob, String emailid, String phoneno, String username, String password,
		String address, double walletamount, String typeOfUser) {
	super();
	this.userid = userid;
	this.name = name;
	this.dob = dob;
	this.emailid = emailid;
	this.phoneno = phoneno;
	this.username = username;
	this.password = password;
	this.address = address;
	this.walletamount = walletamount;
	this.typeOfUser = typeOfUser;
}

public User(String name, Date dob, String emailid, String phoneno, String username, String password, String address,
		double walletamount, String typeOfUser) {
	super();
	this.name = name;
	this.dob = dob;
	this.emailid = emailid;
	this.phoneno = phoneno;
	this.username = username;
	this.password = password;
	this.address = address;
	this.walletamount = walletamount;
	this.typeOfUser = typeOfUser;
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

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public String getPhoneno() {
	return phoneno;
}

public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
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

@Override
public String toString() {
	return "User [userid=" + userid + ", name=" + name + ", dob=" + dob + ", emailid=" + emailid + ", phoneno="
			+ phoneno + ", username=" + username + ", password=" + password + ", address=" + address + ", walletamount="
			+ walletamount + ", typeOfUser=" + typeOfUser + "]";
}

}
