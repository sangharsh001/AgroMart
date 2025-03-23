<%@page import="java.util.ArrayList"%>
<%@page import="com.timex.dao.ProductDaoImpl"%>
<%@page import="com.timex.dao.ProductDAO"%>
<%@page import="com.timex.dto.Product"%>
<%@page import="com.timex.dto.Timex"%>
<%@page import="com.timex.dto.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="StyleCart.css">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/js/all.min.js" integrity="sha512-b+nQTCdtTBIRIbraqNEwsjB6UvL3UEMkXnhzd8awtCYh0Kcsjl9uEgwVFVbhoj3uu1DO1ZMacNvLoyJJiNfcvg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>



<div class="mtop">
<div class="top">
<%
String success=(String)request.getAttribute("success");
if(success!=null)
{%>
<h1 align="center" style="color:green"><%=success %></h1>
<%} %>

<a href="shop.jsp"><button id="bk"> <i class="fa-solid fa-chevron-left" id="bi"></i>Back </button></a>


<% 

Timex user=(Timex)session.getAttribute("user"); 


	ProductDAO  pdao=new ProductDaoImpl();
	
	

	ArrayList<Cart> cart1=pdao.getCart(user);
	
	for(Cart c:cart1)
	{
	
		
		
	
	
	
	
%>


 	
<form action="placeorder" method="post">
	<div class="topo">
<div class="op">

	<div class="ph">
	
	<img src="<%= c.getPic() %>" width="245" height="350" id="pi">
	<label id="lbl">Select qty <%=c.getQty() %></label>
	<select name="qty">
	   
		<option value="1" >1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
	</select>
</div>
<div class="pc">
   <!-- <h3 id="oh">Your Order Has Been Placed</h3> -->
	<h3 id="oc">Rolex Watch series 5 blue</h3>
</div>

<div class="add">
	<h3>Order Address</h3>
	<h4><%=c.getStreet() %></h4>
	<h4><%=c.getCity() %></h4>
	<h4><%=c.getPhone() %></h4>
</div>

<div class="ta">
	<h3><%=c.getAmount() %></h3>
	<div class="pr">
		<div class="po">
		
		 
		 <input type="hidden" name="order" value="<%= c.getProductid() %>">
		 <input type="submit" id="pl" value="PLACE ORDER">
		 </form>
			
	</div>
	<div class="rm">
		<form action="removecart" method="post">
		 
		 <input type="hidden" name="remove" value="<%=c.getProductid() %>">
		 <input type="submit" id="ro" value="REMOVE1">
		 </form>
	</div>
</div>

</div>

</div>
</div>



<%} %>



</div>
</div>
</body>
</html>