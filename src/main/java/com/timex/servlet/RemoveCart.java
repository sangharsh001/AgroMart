package com.timex.servlet;

import java.io.IOException;

import com.timex.dao.ProductDAO;
import com.timex.dao.ProductDaoImpl;
import com.timex.dto.Cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/removecart")
public class RemoveCart  extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart c=new Cart();
		ProductDAO pdao=new ProductDaoImpl();
		c.setProductid(Long.parseLong(req.getParameter("remove")));
		
		System.out.println(c.getProductid());
		
		if(pdao.deleteCart(c))
		{
			req.setAttribute("suucces","Product has been removed");
			RequestDispatcher rd=req.getRequestDispatcher("cart.jsp");
			rd.forward(req, resp);
			
		}
		else
		{
			req.setAttribute("suucces","Product not removed");
			RequestDispatcher rd=req.getRequestDispatcher("cart.jsp");
			rd.forward(req, resp);
		
		}
		
		
	}
}
