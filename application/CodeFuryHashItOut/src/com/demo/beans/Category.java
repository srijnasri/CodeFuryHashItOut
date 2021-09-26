package com.demo.beans;

public class Category 
{
private int cid;
private String name;
private String description;
public Category()
{
	super();
	this.cid = 0;
	this.name = null;
	this.description = null;
	
}


public Category(int cid, String name, String description) {
	super();
	this.cid = cid;
	this.name = name;
	this.description = description;
}


public int getCategoryID() {
	return cid;
}
public void setCategoryID(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Category [categoryID=" + cid + ", Name=" + name + ", description=" + description + "]";
}

}