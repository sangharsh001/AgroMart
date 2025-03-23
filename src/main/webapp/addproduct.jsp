<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            text-align: center;
        }
        .navbar {
            background-color: #fff;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .navbar a {
            text-decoration: none;
            color: black;
            margin: 0 15px;
            font-size: 16px;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            margin: auto;
        }
        h2 {
            margin-bottom: 20px;
        }
        .form-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 15px;
            padding: 5px;
        }
        .form-group {
            display: flex;
            flex-direction: column;
            text-align: left;
            margin-bottom: 10px;
        }
        .form-group label {
            font-size: 14px;
            margin-bottom: 5px;
        }
        .form-group input, .form-group textarea {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
        }
        .full-width {
            grid-column: span 2;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .products {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 30px;
        }
        .product-card {
            background: white;
            padding: 15px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 250px;
            text-align: center;
        }
        .product-card img {
            width: 200px;
            height: 400px;
            border-radius: 5px;
        }
        .product-card h3, .product-card p {
            margin: 10px 0;
        }
        .price {
            color: blue;
            font-weight: bold;
        }
        .actions {
            display: flex;
            justify-content: center;
            gap: 5px;
        }
        .update-btn {
            background: orange;
            color: white;
            padding: 8px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .delete-btn {
            background: red;
            color: white;
            padding: 8px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div><strong>Admin<span style="color:blue;">Panel</span></strong></div>
        <div>
            <a href="#">home</a>
            <a href="#">products</a>
            <a href="#">orders</a>
            <a href="#">admins</a>
            <a href="#">users</a>
            <a href="#">messages</a>
        </div>
    </div>
    
    <div class="container">
   
        <h2>ADD PRODUCT</h2>
         <form action="addproduct" method="post" enctype="multipart/form-data">
            <div class="form-container">
                <div class="form-group">
                    <label>Product Name (required)</label>
                    <input name="pname" type="text" placeholder="Enter product name" >
                </div>
                <div class="form-group">
                    <label>Product Price (required)</label>
                   <input name="pprice" type="number" step="0.01" placeholder="Enter product price" >

                </div>
                <div class="form-group">
        <label>Image 01 (required)</label>
        <input name="image1" type="file" >
    </div>
                
                <div class="form-group full-width">
                    <label>Product Details (required)</label>
                    <textarea name="pdetails" placeholder="Enter product details"  rows="4"></textarea>
                </div>
            </div>
            <input type="submit" class="btn" value="AddProduct">
        </form>
    </div>

    <h2 style="margin-top: 90px;">PRODUCTS ADDED</h2>
    <div class="products">
        <div class="product-card">
            <img src="w5.jpeg" alt="tv">
            <h3>tv</h3>
            <p class="price">$169/-</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ullam culpa eius quos veniam modi libero illo pariatur perspiciatis fugit?</p>
            <div class="actions">
                <button class="update-btn">Update</button>
                <button class="delete-btn">Delete</button>
            </div>
        </div>
    </div>
</body>
</html>
