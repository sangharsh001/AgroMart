<%@page import="com.timex.dao.TimexDao"%>
<%@page import="com.timex.dao.TimexDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.timex.dto.Timex" %>
  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="StyleDash.css">
    
</head>
<body>
    <div class="mtop">
<div class="top">
    <div class="navbar">
        <div><strong>Admin<span style="color:blue;">Panel</span></strong></div>
        <div>
            <a href="#">home</a>
            <a href="addproduct.jsp">products</a>
            <a href="#">orders</a>
            <a href="#">admins</a>
            <a href="viewalluser.jsp">users</a>
        </div>
    </div>
    
    
       <%String successmg=(String)session.getAttribute("successmg"); 
       if(successmg!=null){%>
 <h1 align="center" style="color:red"><%=successmg %></h1>
    <%} %>
    
    
    
    <%
    Integer countObj = (Integer) session.getAttribute("count"); 
   
    %>
    
      <%
    Integer countObj1 = (Integer) session.getAttribute("count1"); 
   
    %>
    
    <%Timex tx=(Timex)session.getAttribute("admin"); %>
    
    <%TimexDao tdao=new TimexDaoImpl(); 
     
    %>
    <h2>DASHBOARD</h2>
    
    <div class="cards-container">
        <div class="card">
            <h3>Welcome!</h3>
            <p><%=tx.getFname()%></p>
            <a href="#" class="btn">Update Profile</a>
        </div>
        <div class="card">
            <h3><%=countObj1 %></h3>
            <p>orders placed</p>
            <a href="Admonorder.jsp" class="btn">See Orders</a>
        </div>
        <div class="card">
            <h3><%=countObj%></h3>
            <p>products added</p>
            <a href="viewallproduct.jsp" class="btn">See Products</a>
        </div>
        <div class="card">
            <h3><%= tdao.userCount() %></h3>
            <p>normal users</p>
            <a href="viewalluser.jsp" class="btn">See Users</a>
        </div>
        <div class="card">
            <h3>1</h3>
            <p>admin users</p>
          
    
            <a href="adminlist.jsp" class="btn">See Admins</a>
        </div>
    </div>
</div>
</div>
</body>
</html>
