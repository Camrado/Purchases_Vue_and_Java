package com.javatpoint.rest.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Purchase {
	private int ID;
	private Date p_date;
	private String Category;
	private String Item;
	private float Price;
	private int Quantity;
	private float Total_price;
	
	public Purchase() {
		
	}
	
	//	ID
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	//	Date
	public String getDate() {		
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");		
		return date_format.format(p_date);
	}
	public void setDate(Date p_date) {
		this.p_date = p_date;
	}
	
	// 	Category
	public String getCategory() {
		return Category;
	}
	public void setCategory(String Category) {
		this.Category = Category;
	}
	
	//	Item
	public String getItem() {
		return Item;
	}
	public void setItem(String Item) {
		this.Item = Item;
	}
	
	//	Price
	public float getPrice() {
		return Price;
	}
	public void setPrice(float Price) {
		this.Price = Price;
	}
	
	//	Quantity
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
	
	//	Total_price
	public float getTotal_price() {
		return Total_price;
	}
	public void setTotal_price(float Total_price) {
		this.Total_price = Total_price;
	}

}
