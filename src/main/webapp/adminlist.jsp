<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.timex.dto.Products"%>
<%@page import="com.timex.dao.TimexDaoImpl"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.timex.dao.TimexDaoImpl" %>
<%@ page import="com.timex.dao.TimexDao" %>
<%@ page import="com.timex.dto.Timex" %>

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
   
            <a class="nav-link" href="#">View All Users</a>
       
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
                <th>ID</th>
                <th>Name</th>
              
                <th>Email</th>
                  <th>Phone</th>
                <th>Street</th>
                <th>City</th>
                <th>State</th>
                  <th>Country</th>
                    <th>ZipCode</th>
                      <th>Action</th>
            </tr>
        </thead>
        <tbody>
       
        <%
            TimexDao tdao = new TimexDaoImpl();
        // System.out.println("iam in viewll page12");
            ArrayList<Timex> userList = tdao.viewallUser();
           // System.out.println(userList);
            for (Timex data : userList) {
            	
            	if(data.getId()==12){
        %>
            <tr>
                <td><%= data.getId() %></td>
                <td><%= data.getFname() %></td>
                <td><%= data.getEmail() %></td>
                <td><%= data.getPhoneno() %></td>
                 <td><%= data.getStreet() %></td>
                <td><%= data.getCity() %></td>
                 <td><%= data.getState() %></td>
               
                <td><%= data.getCountry() %></td>
                <td><%= data.getZipcode() %></td>
                <td>
                    <form action="delete" method="post">
                        <input type="hidden" name="studentId" value="<%= data.getId() %>">
                        <input type="submit" class="btn btn-danger" value="Delete">
                    </form>
                </td>
            </tr>
        <% } }%>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>

</body>
</html>
