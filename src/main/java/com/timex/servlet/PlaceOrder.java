package com.timex.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.timex.dao.ProductDAO;
import com.timex.dao.ProductDaoImpl;
import com.timex.dto.Cart;
import com.timex.dto.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/placeorder")
public class PlaceOrder extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	Cart c=new Cart();
	ProductDAO pdao=new ProductDaoImpl();
	c.setProductid(Long.parseLong(req.getParameter("order")));
	System.out.println(c.getProductid());
	
  Order or=new Order();
   ArrayList<Cart> order=pdao.orderDetail(c);
ArrayList<Order> arr=null;
   boolean add=false;
   for(Cart c1:order)
   {
	   c1.setQty(Integer.parseInt(req.getParameter("qty")));
	 
       if(add=pdao.insertOrder(c1)) {
    	   arr= pdao.orderDetail(c1.getUid());
    	   
    	   
    	 
    	   
    	   
    	   
       }
     pdao.deleteCart(c1);
   }
   
   System.out.println(arr);
 
HttpSession sess=req.getSession(true);
   	System.out.println(order);
   if(order!=null)
	   {
	   if(add)
	   {
		   
		   sess.setAttribute("order", arr);

	   req.setAttribute("delete","Deleted Successfully");
		RequestDispatcher  rd=req.getRequestDispatcher("order.jsp");
		rd.forward(req, resp);
	   
	   }
	   
   }
   else
   {
	   req.setAttribute("delete","Deleted Successfully");
		RequestDispatcher  rd=req.getRequestDispatcher("viewalluser.jsp");
		rd.forward(req, resp);
   }
   
   
   


	
	
}
}
