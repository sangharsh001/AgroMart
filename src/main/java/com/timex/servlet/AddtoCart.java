package com.timex.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.timex.dao.ProductDAO;
import com.timex.dao.ProductDaoImpl;
import com.timex.dao.TimexDao;
import com.timex.dao.TimexDaoImpl;
import com.timex.dto.Cart;
import com.timex.dto.Product;
import com.timex.dto.Timex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/AddCart")
public class AddtoCart extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TimexDao tdao=new TimexDaoImpl();
		ProductDAO  pdao=new ProductDaoImpl();
		HttpSession session = req.getSession(false);  // ❌ Does NOT create a new session
		if (session == null) {
		    resp.sendRedirect("login.jsp");  // ✅ Redirect if session does not exist
		    return;
		}

		// ✅ Now, safely access session attributes
		Timex user = (Timex) session.getAttribute("user"); 
		
		if (user == null) {
		    resp.sendRedirect("login.jsp");  // ✅ Redirect if user is not logged in
		    return;
		}

		
//		long pid=Long.parseLong(req.getParameter("pid"));
		
		
		Product p=pdao.addCart(Long.parseLong(req.getParameter("pid")));
		
		
		
		System.out.println(p.getId());
		System.out.println(p.getPname());
		HttpSession cart=req.getSession(true);
		if(pdao.updateCart(p, user))
		{
			ArrayList<Cart> cart1=pdao.getCart(user);
			if(cart1!=null)
			{
				
				
				cart.setAttribute("cart",cart1);
//				req.setAttribute("", cart);
				RequestDispatcher rd=req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
				
			}
			
		}	
		else
		{
			
		if(tdao.incQty(p)) {}
			RequestDispatcher rd=req.getRequestDispatcher("cart.jsp");
			rd.forward(req, resp);
		
		
		}
	}

}
