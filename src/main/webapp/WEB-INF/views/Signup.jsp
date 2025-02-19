<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>
 	<h2>Signup</h2>
 	
 	<br>
 	
 	 <form action="saveuser" method="post">
        
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" required>
        
        <br><br>

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" required>
        
        <br><br>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
        
        <br><br>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        
        <br><br>

        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        
        <br><br>
      

        <label for="contactNum">Contact Number</label>
        <input type="tel" id="contactNum" name="contactNum" required>
        
        <br><br>

		<label for="profilePhoto">Contact Number</label>
        <input type="file" id="profilePhoto" name="profilePhoto" required>
        
        <br><br>
		
        <button type="submit">Submit</button>
    </form>
 	
 	<a href = "login">Login</a>
</body>
</html>