package com.javatpoint.rest.entity;

public class Category {
	private int ID;
	private String Name;
	private String Description;
	
	public Category() {
		
	}
	
	//ID
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	//Name
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	//Description
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}

}
