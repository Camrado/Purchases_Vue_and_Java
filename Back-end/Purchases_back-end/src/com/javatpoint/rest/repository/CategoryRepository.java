package com.javatpoint.rest.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.rest.entity.Category;

public class CategoryRepository implements ICategoryRepository {

	@Override
	public List<Category> getAll() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
		
		ResultSet myRs = myStmt.executeQuery("select * from purchases_categories");
		
		List<Category> categories = new ArrayList<>();
		
		try {
			while(myRs.next()) {
				
				Category category = new Category();
				category.setID(myRs.getInt("ID"));
				category.setName(myRs.getString("Name"));
				category.setDescription(myRs.getString("Description"));
				
				categories.add(category);
			}	
			
		} finally {
			myRs.close();
	        myStmt.close();
	        myConn.close();
		}
		
		return categories;
	}

	@Override
	public Category getById(int id) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
		
		ResultSet myRs = myStmt.executeQuery("select * from purchases_categories where ID = " + id);
		
		Category category = new Category();
		
		try {
			while(myRs.next()) {
				
				category.setID(myRs.getInt("ID"));
				category.setName(myRs.getString("Name"));
				category.setDescription(myRs.getString("Description"));
				
				break;
			}	
			
			
		} finally {
			myRs.close();
	        myStmt.close();
	        myConn.close();
		}
		
		return category;
	}

	@Override
	public void insert(Category category) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
				
		String sql = "insert into purchases_categories (Name, Description) " +
				"values ('" + category.getName() + "', '" + category.getDescription() + "')";
		
		try {
			myStmt.executeUpdate(sql);
			
		} finally {
	        myStmt.close();
	        myConn.close();
		}
	}

	@Override
	public void update(Category category) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchases", "root", "root");
		Statement myStmt = myConn.createStatement();
				
		String sql = "UPDATE purchases_categories "+
					"SET Name = '" + category.getName() + "', " +
					"Description = '" + category.getDescription() + "' " +
					"WHERE ID = " + category.getID();
		
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
			
		String sql = "DELETE FROM purchases_categories WHERE ID = " + id;
		
		myStmt.executeUpdate(sql);
		
		
		} finally {
	        myStmt.close();
	        myConn.close();
		}
	}

}
