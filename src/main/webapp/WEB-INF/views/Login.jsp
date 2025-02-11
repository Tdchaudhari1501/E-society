<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<br>
	
	 <form action="#" method="post">
        <label for="loginEmail">Email</label>
        <input type="email" id="loginEmail" name="email" required>
        
        <br><br>

        <label for="loginPassword">Password</label>
        <input type="password" id="loginPassword" name="password" required>
        
        <br><br>

        <button type="submit">Login</button>
        
        <a href = "forgotpassword">Forgot Password?</a>
    </form>
    <br><br>
	<a href="signup">Signup</a>
	
</body>
</html>