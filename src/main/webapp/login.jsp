<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea, #764ba2);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 350px;
        }
        .container h2 {
            margin-bottom: 20px;
            color: #333;
        }
        input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 30px;
            font-size: 16px;
            text-align: center;
        }
        .remember {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 14px;
            margin: 10px 0;
        }
        .remember a {
            text-decoration: none;
            color: #667eea;
        }
        .login-btn {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 30px;
            font-size: 18px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            cursor: pointer;
            transition: 0.3s;
        }
        .login-btn:hover {
            background: linear-gradient(135deg, #564bb2, #5e4ca2);
        }
        .signup {
            margin-top: 10px;
            font-size: 14px;
        }
        .signup a {
            text-decoration: none;
            color: #667eea;
        }
    </style>
</head>
<body>
    <div class="container">
  
    
    <%String error=(String)request.getAttribute("error"); if(error!=null){%>
 <h1 align="center" style="color:red"><%=error %></h1>
    <%} %>
    
     <%String success=(String)request.getAttribute("success"); 
     if(success!=null){%>
 <h1 align="center" style="color:red"><%=success %></h1>
    <%} %>
    
    
    <form action="login" method="post">
    
        <h2>Login Form</h2>
        <input  name ="email" type="email" placeholder="Email Address" id="email">
        <input name="password" type="password" placeholder="Password" id="password">
       
         <input class="login-btn" type="submit" value="Submit">
         
        <p class="signup">Not a member? <a href="signup.jsp">Signup now</a></p>
        </form>
    </div>
    <script>
        function login() {
            let email = document.getElementById('email').value;
            let password = document.getElementById('password').value;
            if (email === '' || password === '') {
                alert('Please fill in all fields.');
                return;
            }
            alert('Login Successful!');
        }
    </script>
</body>
</html>
