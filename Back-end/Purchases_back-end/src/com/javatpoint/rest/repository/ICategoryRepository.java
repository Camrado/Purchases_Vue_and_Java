package com.javatpoint.rest.repository;

import java.sql.SQLException;
import java.util.List;

import com.javatpoint.rest.entity.Category;

public interface ICategoryRepository {
	List<Category> getAll() throws SQLException, ClassNotFoundException;
	Category getById(int id) throws SQLException, ClassNotFoundException;
	
	void insert(Category category) throws SQLException, ClassNotFoundException;
	void update(Category category) throws SQLException, ClassNotFoundException;
	void deleteById(int id) throws SQLException, ClassNotFoundException;
}
