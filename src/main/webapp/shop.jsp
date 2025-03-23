<%@page import="com.timex.dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.timex.dao.ProductDaoImpl"%>
<%@page import="com.timex.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="StyleShop1.css">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/js/all.min.js" integrity="sha512-b+nQTCdtTBIRIbraqNEwsjB6UvL3UEMkXnhzd8awtCYh0Kcsjl9uEgwVFVbhoj3uu1DO1ZMacNvLoyJJiNfcvg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<title></title>
	
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
	<a href="timexhome.jsp" id="home">Home</a>
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
	<a href="cart.jsp" id="wish"><i class="fa-solid fa-cart-shopping"></i></a>
</div>

</div>




  <!-- ✅ Product Display Section -->
        <div class="product-container  row" >
            <%
                ProductDAO pdao = new ProductDaoImpl();
                ArrayList<Product> userList = pdao.viewAllProduct();

                for (Product p : userList) {
                    // Ensure a valid image source
                    String imageSrc = (p.getBase64Image() != null && !p.getBase64Image().isEmpty()) ? 
                                      p.getBase64Image() : "placeholder.jpg";
            %>
            <div class="imgtop col-lg-3"  >
                <div class="itemf" >
                    <img src="<%= imageSrc %>" alt="Product Image" width="245" height="310" id="wim">

                    <div class="des">
                        <h3><%= p.getPname() %></h3>
                        <p>₹<%= p.getPrice() %></p>

                        <div class="ab1">
                            <div class="add">
                                <form action="AddCart" method="post">
                                    <input type="hidden" name="pid" value="<%=p.getId()%>">
                                    <input type="submit" id="ac" value="Add To Cart">
                                </form>
                            </div>

                            <div class="buy">
                                <form action="AddCart" method="post">
                                    <input type="hidden" name="pid" value="<%= p.getId() %>">
                                    <input type="submit" id="bu" value="Buy">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
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

</div>

</body>
</html>


