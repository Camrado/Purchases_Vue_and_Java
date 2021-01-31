package com.javatpoint.rest.repository;

import java.sql.SQLException;
import java.util.List;

import com.javatpoint.rest.entity.Purchase;

public interface IPurchaseRepository {
	List<Purchase> getAll() throws SQLException, ClassNotFoundException;
	Purchase getById(int id) throws SQLException, ClassNotFoundException;
	
	void insert(Purchase purchase) throws SQLException, ClassNotFoundException;
	void update(Purchase purchase) throws SQLException, ClassNotFoundException;
	void deleteById(int id) throws SQLException, ClassNotFoundException;
}
