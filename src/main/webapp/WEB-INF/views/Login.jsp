<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<br>
	
	 <form action="authenticate" method="post">
        <label for="loginEmail">Email</label>
        <input type="email" id="loginEmail" name="email" required>
        
        <br><br>

        <label for="loginPassword">Password</label>
        <input type="password" id="loginPassword" name="password" required>
        
        <br><br>

        <button type="submit">Login</button>
        
  
    </form><br>
    
    ${error}
    <br><br>
          <a href = "forgotpassword">Forgot Password?</a>
   
    
	<a href="signup">Signup</a>
	<br>
	
	
	
</body>
</html>