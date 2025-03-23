package com.timex.servlet;
 
import java.io.IOException;


import com.timex.dao.TimexDao;
import com.timex.dao.TimexDaoImpl;
import com.timex.dto.Timex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 TimexDao tdao=new TimexDaoImpl();
		 System.out.println("succes");
		
		Timex tx=tdao.getRecord(req.getParameter("email"), req.getParameter("password"));
		
		if(tx!=null) {
			//System.out.println(s.getName());
//			System.out.println(tx.getCity());
			HttpSession session=req.getSession(true);
			
			
			if(tx.getId()==12)
			{
				
				session.setAttribute("admin",tx);
				req.setAttribute("successmg", "Data saved successfully");
				RequestDispatcher rd=req.getRequestDispatcher("admindash.jsp");
		      	rd.forward(req, resp);
				
			}
			else {
				session.setAttribute("user", tx);
				
			req.setAttribute("success", "Data saved successfully");
			RequestDispatcher rd=req.getRequestDispatcher("timexhome.jsp");
	      	rd.forward(req, resp);
			}
	      	
	      	
	    
			
			}else {
				
				
				
				System.out.println("succes");
				req.setAttribute("error", "Login unSuccessfull");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		      	rd.forward(req, resp);
			}
	}

}
