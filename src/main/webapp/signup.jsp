<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
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
            width: 40%;
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.2);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        input, select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        .form-row {
            display: flex;
            gap: 20px;
        }
        .form-row input, .form-row select {
            flex: 1;
        }
        .gender-options {
            display: flex;
            gap: 15px;
            align-items: center;
        }
        .submit-btn {
            width: 100%;
            padding: 15px;
            background: #5A33A2;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s;
        }
        .submit-btn:hover {
            background: #47247A;
        }
    </style>
</head>
<body>

    <div class="container">
     <%String res=(String)request.getAttribute("success"); if(res!=null){%>
    <h1 align="center" style="color:green"><%=res %></h1>
    <%} %>
    
    <%String error=(String)request.getAttribute("error"); if(error!=null){%>
 <h1 align="center" style="color:red"><%=error %></h1>
    <%} %>
    
    <form action="signup" method="post">
   
        <h2>Registration Form</h2>
        <div class="form-group">
            <label>Full Name</label>
            <input name="fname" type="text" placeholder="Enter your name">
        </div>
        <div class="form-group">
            <label>Email Address</label>
            <input name="email" type="email" placeholder="Enter email address">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input name="password" type="password" placeholder="Enter your password">
        </div>
        <div class="form-row">
            <div class="form-group">
                <label>Phone Number</label>
                <input name="phoneno" type="text" placeholder="Enter phone number">
            </div>
            <div class="form-group">
                <label>Birth Date</label>
                <input name="dob" type="date">
            </div>
        </div>
        <div class="form-group">
            <label>Gender</label>
            <div class="gender-options">
                <input type="radio" name="gender" value="Male"> Male
                <input type="radio" name="gender" value="Female"> Female
                <input type="radio" name="gender" value="Other"> Other
            </div>
        </div>
        <div class="form-group">
            <label>Address</label>
            <input name="street" type="text" placeholder="Street Address">
            <input name="city" type="text" placeholder="City">
            <div class="form-row">
                <select name="country">
                    <option >Country</option>
                    <option>USA</option>
                    <option>Canada</option>
                </select>
                <select name="state">
                    <option>State</option>
                    <option>California</option>
                    <option>Texas</option>
                </select>
            </div>
            <div class="form-row">
                <input name="district" type="text" placeholder="District">
                <input name="zipcode" type="number" placeholder="Zip Code">
            </div>
        </div>
        <input type="submit" class="submit-btn" value="submit">
        <br>
        <p>Already Have An Account? <a href="login.jsp">Click Here</a> </p>
         </form>
    </div>
   
    <script>
            event.preventDefault();
            let name = document.querySelector('input[placeholder="Enter your name"]').value;
            let email = document.querySelector('input[placeholder="Enter email address"]').value;
            let password = document.querySelector('input[placeholder="Enter your password"]').value;
            let phone = document.querySelector('input[placeholder="Enter phone number"]').value;
            let birthDate = document.querySelector('input[type="date"]').value;
            let gender = document.querySelector('input[name="gender"]:checked');
            let address = document.querySelector('input[placeholder="Street Address"]').value;
            let city = document.querySelector('input[placeholder="City"]').value;
            let country = document.querySelector('select').value;
            let state = document.querySelectorAll('select')[1].value;
            let district = document.querySelector('input[placeholder="District"]').value;
            let zip = document.querySelector('input[placeholder="Zip Code"]').value;
            
            if (!name || !email || !password || !phone || !birthDate || !gender || !address || !city || !country || !state || !district || !zip) {
                alert('Please fill in all fields.');
                return;
            }
            
            alert('Registration Successful!');
        });
    </script>
</body>
</html>
