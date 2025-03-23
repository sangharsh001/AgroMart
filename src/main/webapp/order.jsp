<%@page import="com.timex.dao.ProductDAO"%>
<%@page import="com.timex.dao.ProductDaoImpl"%>
<%@page import="com.timex.dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.timex.dto.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="StyleOrder.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/js/all.min.js" integrity="sha512-b+nQTCdtTBIRIbraqNEwsjB6UvL3UEMkXnhzd8awtCYh0Kcsjl9uEgwVFVbhoj3uu1DO1ZMacNvLoyJJiNfcvg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>


<body>

	<div class="mtop">
<div class="top">
<div class="navi">

<div class="topsl">
	<div class="sl">
	<h1 id="logo">TIMEX</h1>
</div>

<div class="sea">
	<input type="text" name="name" placeholder="Search your dream watch">
</div>
</div>

<div class="hs">
	<a href="#" id="home">Home</a>
</div>

<div class="hs">
	<a href="#" id="shop">Shop</a>
</div>

<div class="hs">
	<a href="#" id="order">Orders</a>
</div>

<div class="hs">
	<a href="#" id="contact">Contact</a>
</div>

<div class="hs">
	<a href="#" id="wish"><i class="fa-solid fa-cart-shopping"></i></a>
</div>

</div>
<%
ProductDAO pdao=new ProductDaoImpl();

ArrayList<Order> user=pdao.AllOrder();


if (user != null) 
{
   
    
for(Order c:user)
{


%>




<div class="topo">
<div class="op">
	<div class="ph">
	<img src="<%= c.getPic() %>" width="245" height="350" id="pi">
</div>
<div class="pc">
   <h3 id="oh">Your Order Has Been Placed</h3>
	<h4 id="oc">Rolex Watch series 5 blue</h4>
</div>

<div class="add">
	<h3>Order Address</h3>
	<h4><%=c.getStreet() %></h4>
	<h4><%=c.getCity() %></h4>
	<h4><%=c.getPhone() %></h4>
</div>

<div class="ta">
	<h3><%= c.getAmount() %></h3>
</div>

</div>

</div>
<%} }%>








</div>



<div class=fo1>
<div class="fo2">
<div class="ab">
    <h4>COLLECTIONS</h4>
    <p>Tropical Fruits</p>
    <p>Citrus Fruits</p>
    <p>Berries</p>
    <p>Exotic Fruits</p>
    <p>Organic Fruits</p>
</div>

<div class="cu">
	<h4>CONTACT US</h4>
	<p>1800-603-1254</p>
	<p>customercare@agromart.in</p>
	<p>Help</p>
	<p>FAQs</p>
</div>

<div class="at">
	<h4>ABOUT AgroMart</h4>
	<p>Brand Protection</p>
	<p>Corporate</p>
	<p>Careers</p>
	<p>Blog</p>
</div>
</div>



<div class="lastline">
<div class="fl">
	<hr id="lin">
</div>
<div class="bl">
<h2>AgroMart</h2>
</div>
<div class="fl">
	<hr id="lin">
</div>
</div>

<div class="logo">
	<i class="fa-brands fa-facebook" id="you"></i>
	<i class="fa-brands fa-x-twitter" id="you"></i>
	<i class="fa-brands fa-instagram" id="you"></i>
	<i class="fa-brands fa-youtube" id="you"></i>
	<i class="fa-brands fa-pinterest" id="you"></i>
	<i class="fa-brands fa-linkedin" id="you"></i>
</div>

</div>

</body>
</html>