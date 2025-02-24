<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login | e-Society</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f4f4f4;
        }
        .login-container {
            margin-top: 100px;
            max-width: 400px;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        .login-title {
            font-weight: bold;
            margin-bottom: 20px;
        }
        .form-control {
            border-radius: 6px;
        }
        .btn-login {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
            border-radius: 6px;
            transition: 0.3s;
        }
        .btn-login:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
        
    <div class="container d-flex justify-content-center">
    
        <div class="login-container text-center">
               
           <h3 class=" w-100" >Login</h3>
            <!-- Login Form -->
            <form action="authenticate" method="post">
                <div class="mb-3">
                    <input type="email" name="email" id="loginEmail"class="form-control" placeholder="email" required>
                </div>
                <div class="mb-3">
                    <input type="password" id="loginPassword" name="password" class="form-control" placeholder="Enter Password" required>
                </div>
                <button type="submit" class="btn btn-login w-100">Login</button>
            </form>
            ${error}
            

            <!-- Register & Forgot Password Links -->
            <div class="mt-3">
                <a href="signup" class="text-decoration-none">New User? Register</a>
                <span class="mx-2">|</span>
                <a href="forgotpassword" class="text-decoration-none">Forgot Password?</a>
            </div>
        </div>
    </div>

</body>
</html>

