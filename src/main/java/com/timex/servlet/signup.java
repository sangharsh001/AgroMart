package com.timex.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.timex.dao.*;
import com.timex.dto.Timex;
@WebServlet("/signup")
public class signup extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 TimexDao tdao=new TimexDaoImpl();
		 Timex tx=new Timex();
	              
		 tx.setFname(req.getParameter("fname"));
	     tx.setEmail(req.getParameter("email"));
tx.setPassword(req.getParameter("password"));
//	  String password=req.getParameter("password");

tx.setPhoneno(Long.parseLong(req.getParameter("phoneno")));
	tx.setDob(req.getParameter("dob"));
//	String dob=req.getParameter("dob");
	tx.setGender(req.getParameter("gender"));
	tx.setStreet(req.getParameter("street"));
	tx.setCity(req.getParameter("city"));
tx.setCountry(req.getParameter("country"));
tx.setState(req.getParameter("state"));
tx.setDistrict(req.getParameter("district"));
tx.setZipcode(req.getParameter("zipcode"));
	boolean res=tdao.insertRecord(tx);
	if(res) {
		req.setAttribute("success", "Data saved successfully");
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	else
	{
		req.setAttribute("error", "Registration failed");
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	
	  
	  
	}

}
