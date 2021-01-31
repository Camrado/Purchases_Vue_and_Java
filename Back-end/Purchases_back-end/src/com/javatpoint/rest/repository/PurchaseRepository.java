package com.javatpoint.rest.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.rest.entity.Purchase;

public class PurchaseRepository implements IPurchaseRepository {

	@Override
	public List<Purchase> getAll() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
		
		ResultSet myRs = myStmt.executeQuery("select * from purchases_table");
		
		List<Purchase> purchases = new ArrayList<>();
		
		try {
			while(myRs.next()) {
				
				Purchase purchase = new Purchase();
				purchase.setID(myRs.getInt("ID"));
				purchase.setDate(myRs.getDate("Date"));
				purchase.setCategory(myRs.getString("Category"));
				purchase.setItem(myRs.getString("Item"));
				purchase.setPrice(myRs.getFloat("Price"));
				purchase.setQuantity(myRs.getInt("Quantity"));
				purchase.setTotal_price(myRs.getFloat("Total_price"));
				
				purchases.add(purchase);
			}	
			
			
		} finally {
			myRs.close();
	        myStmt.close();
	        myConn.close();
		}
		
		return purchases;
	}

	@Override
	public Purchase getById(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
		
		ResultSet myRs = myStmt.executeQuery("select * from purchases_table where ID = " + id);
		
		Purchase purchase = new Purchase();
		
		try {
			while(myRs.next()) {
				
				purchase.setID(myRs.getInt("ID"));
				purchase.setDate(myRs.getDate("Date"));
				purchase.setCategory(myRs.getString("Category"));
				purchase.setItem(myRs.getString("Item"));
				purchase.setPrice(myRs.getFloat("Price"));
				purchase.setQuantity(myRs.getInt("Quantity"));
				purchase.setTotal_price(myRs.getFloat("Total_price"));
				
				break;
			}	
			
			
		} finally {
			myRs.close();
	        myStmt.close();
	        myConn.close();
		}
		
		return purchase;
	}

	@Override
	public void insert(Purchase purchase) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
				
		String sql = "insert into purchases_table (Date, Category, Item, Price, Quantity) " +
				"values ('" + purchase.getDate() + "', '" + purchase.getCategory() +  "', '" + purchase.getItem() + "', " + purchase.getPrice() + ", " + purchase.getQuantity() + ")";
		
		try {
			myStmt.executeUpdate(sql);
			
		} finally {
	        myStmt.close();
	        myConn.close();
		}
		
	}

	@Override
	public void update(Purchase purchase) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
				
		String sql = "UPDATE purchases_table "+
					"SET Date = '" + purchase.getDate() + "', " +
					"Category = '" + purchase.getCategory() + "', " +
					"Item = '" + purchase.getItem() + "', " +
					"Price = " + purchase.getPrice() + ", " +
					"Quantity = " + purchase.getQuantity() + " " +
					"WHERE ID = " + purchase.getID();
		
		try {
			myStmt.executeUpdate(sql);
			
		} finally {
	        myStmt.close();
	        myConn.close();
		}
		
	}

	@Override
	public void deleteById(int id) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
		
		try {
			
		String sql = "DELETE FROM purchases_table WHERE ID = " + id;
		
		myStmt.executeUpdate(sql);
		
		
		} finally {
	        myStmt.close();
	        myConn.close();
		}
		
	}
	
}
