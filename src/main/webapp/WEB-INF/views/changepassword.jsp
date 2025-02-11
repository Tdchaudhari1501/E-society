<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
</head>
<body>
    <h2>Change Password</h2>
    <form action="updatepassword" method="post">
     <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
        
        <br><br>
        <label for="otp">OTP</label>
        <input type="text" id="otp" name="otp" required>
        
        <br><br>

        <label for="password">New Password</label>
        <input type="password" id="password" name="password" required>
        
        <br><br>

        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        
        <br><br>
         <input type = "submit" value = "UpdatePassword">
    </form>
</body>
</html>