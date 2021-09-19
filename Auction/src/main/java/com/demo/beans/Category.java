package com.demo.beans;

public class Category 
{
private String categoryID;
private String Name;
private String description;
public Category()
{
	super();
	this.categoryID = null;
	Name = null;
	this.description = null;
	
}
public Category(String categoryID, String name, String description) {
	super();
	this.categoryID = categoryID;
	Name = name;
	this.description = description;
}

public String getCategoryID() {
	return categoryID;
}
public void setCategoryID(String categoryID) {
	this.categoryID = categoryID;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Category [categoryID=" + categoryID + ", Name=" + Name + ", description=" + description + "]";
}

}
