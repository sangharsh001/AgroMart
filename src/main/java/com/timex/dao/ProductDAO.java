package com.timex.dao;

import com.timex.dto.Cart;
import com.timex.dto.Order;
import com.timex.dto.Product;
import com.timex.dto.Timex;

import java.util.ArrayList;

public interface ProductDAO {
public ArrayList<Product> viewAllProduct();
public Product addCart(long id);
public boolean updateCart(Product p,Timex t);
public ArrayList<Cart> getCart(Timex t);


public boolean deleteCart(Cart c);

public ArrayList<Cart> orderDetail(Cart c);

public boolean insertOrder(Cart c);

public ArrayList<Order>orderDetail(long uid);

public ArrayList<Order>AllOrder();




}
