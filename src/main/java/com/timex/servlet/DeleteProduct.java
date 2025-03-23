package com.timex.servlet;

import java.io.IOException;

import com.timex.dao.TimexDao;
import com.timex.dao.TimexDaoImpl;
import com.timex.dto.Product;
import com.timex.dto.Timex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	      Product p=new Product();
	     
			TimexDao sdao=new TimexDaoImpl();
			
//		int id=Int.parseint(req.getParameter("studentId"));
			
			p.setId(Integer.parseInt(req.getParameter("productId")));
			System.out.println("djndjdn");
			
			
		    
			
			
			
			if(sdao.deletProduct(p))
			{
				req.setAttribute("delete","Deleted Successfully");
				RequestDispatcher  rd=req.getRequestDispatcher("viewallproduct.jsp");
				rd.forward(req, resp);
				
			}
			else
			{
				req.setAttribute("delete","not Deleted Successfully");
				RequestDispatcher  rd=req.getRequestDispatcher("viewallproduct.jsp");
				rd.forward(req, resp);
			
				
			}
		 
		
			
			
			
			
		
	}

}
