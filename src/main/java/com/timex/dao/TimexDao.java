package com.timex.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.timex.dto.Cart;
import com.timex.dto.Product;
import com.timex.dto.Products;
import com.timex.dto.Timex;

public interface TimexDao {
	
	public boolean insertRecord(Timex t);
	public Timex getRecord(String email,String password);
//	public ArrayList<Timex> viewAllUser();
	
	public ArrayList<Timex>viewallUser();
	
	public boolean deleteUser(Timex t);
	
	public int userCount();
	
	public boolean addProduct(Products p);
	
	public ArrayList<Products> viewAllProduct();
	public boolean deletProduct(Product p);
	
//	 List<Product> viewAllProduct();
	
	
	public boolean incQty(Product t);
//	

}
