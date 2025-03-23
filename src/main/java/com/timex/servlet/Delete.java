package com.timex.servlet;

import java.io.IOException;

import com.timex.dto.Product;
import com.timex.dto.Timex;
import com.timex.dao.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class Delete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
      Timex s=new Timex();
//      Product p=new Product();
     
		TimexDao sdao=new TimexDaoImpl();
		
//	int id=Int.parseint(req.getParameter("studentId"));
		s.setId(Integer.parseInt(req.getParameter("studentId")));
//		p.setId(Integer.parseInt(req.getParameter("productid")));
		System.out.println("djndjdn");
	    
		if(sdao.deleteUser(s))
		{
			req.setAttribute("delete","Deleted Successfully");
			RequestDispatcher  rd=req.getRequestDispatcher("viewalluser.jsp");
			rd.forward(req, resp);
		}
		
		
		
		else
		{
			req.setAttribute("delete","not Deleted Successfully");
			RequestDispatcher  rd=req.getRequestDispatcher("viewalluser.jsp");
			rd.forward(req, resp);
			
		}
	 
	
		
		
		
		
	}
}
