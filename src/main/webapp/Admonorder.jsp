<%@page import="com.timex.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.timex.dto.Product"%>
<%@page import="com.timex.dao.ProductDaoImpl"%>
<%@page import="com.timex.dao.ProductDAO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="com.timex.dto.Products"%>

<%@page import="com.timex.dao.TimexDaoImpl"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.timex.dao.TimexDaoImpl" %>
<%@ page import="com.timex.dao.TimexDao" %>
<%@ page import="com.timex.dto.Timex" %>
<%@ page import="javax.imageio.ImageIO" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .second a {
            padding: 10px;
            margin: 5px;
            color: white;
        }
        .second input {
            margin-left: 10px;
        }
        h3 {
            color: white;
        }
        .final {
            padding: 6px;
            display: flex;
            justify-content: space-between;
            background-color: rgb(87, 76, 76);
        }
        .second {
            display: flex;
        }
        .btn {
            height: 45px;
        }
        h1, h2 {
            color: blue;
            padding: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 2px solid black;
            text-align: center;
            padding: 10px;
        }
    </style>
</head>

<body>

<%
    Timex user = (Timex) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="final">
    <div class="first">
        <h3><%= user.getFname() %></h3>
    </div>

    <div class="second">
        <% if (user.getId() == 12) { %>
            <a class="nav-link" href="#">View All Users</a>
        <% } %>
        <a class="nav-link" href="update.jsp">Update Account</a>
        <a class="nav-link" href="loginser.jsp">Logout</a>
    </div>
</div>

<center><h1>Dashboard</h1></center>
<h2>View Your Data</h2>

 <% String delete=(String)request.getAttribute("delete"); 
    
    if(delete!=null){%>
    <h2 class="mb-3" Style="text-align:center; color:green;"> <%=delete %></h2>
    <%} %>
    
    
    
    <div class="container mt-4">
    <table>
        <thead>
            <tr>
            <th>Order Id</th>
                <th>Product ID</th>
                <th>User Id</th>
                <th>Product Name</th>
                  <th>Product Image</th>
                <th>product Price</th>
                <th>Quantity</th>
                <th>Street</th>
                <th>City</th>
                <th>Aceess</th>
                
            </tr>
        </thead>
        <tbody>
       
        <%
      
        
        int ocount=0;
       
            ProductDAO pdao=new ProductDaoImpl();
        // System.out.println("iam in viewll page12");
            ArrayList<Order> userList = pdao.AllOrder();
           // System.out.println(userList);
            for (Order data : userList) {
            	ocount=ocount+1;
        %>
            <tr>
                <td><%= data.getOrderid() %></td>
                    <td><%= data.getProductid() %></td>
                    <td><%=data.getUid() %></td>
               <td><%=data.getPname() %></td>
              
               <td>  <img src="<%= data.getPic()%>" width="245" height="350" id="wim">
                <td><%= data.getAmount() %></td> 
                
       <!--  byte[] imageBytes = data.getBase64Image();  
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

                
                
                
                -->        
                <td><%= data.getQty() %></td> 
                 <td><%= data.getStreet() %></td>
                  <td><%= data.getCity() %></td>
                  
                
                <td>
                    <form action="" method="post">
                        <input type="hidden" name="productId" value="<%= data.getOrderid() %>">
                        <input type="submit" class="btn btn-danger" value="Delete">
                    </form>
                </td>
            </tr>
            
            <%  
            HttpSession s=request.getSession();
            s.setAttribute("count1", ocount); %>
        <% }%>
        </tbody>
    </table>
</div>
    
    
    
    
    
    
    
    

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>

</body>
</html>
