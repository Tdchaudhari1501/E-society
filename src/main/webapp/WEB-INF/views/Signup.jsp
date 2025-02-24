<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SignUp | e-Society</title>

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
 	 <h2>Signup</h2>
 	
 	<br>
 	
 	 <form action="saveuser" method="post">
         <div class="mb-3">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" class="form-control" required>
        </div>
         <div class="mb-3">

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" class="form-control" required>
        </div>
         <div class="mb-3">

        <label for="email">Email</label>
        <input type="email" id="email" name="email" class="form-control" required>
        </div>
         <div class="mb-3">

        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" required>
        </div>
         <div class="mb-3">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
        </div>
        
         <div class="mb-3">
      

        <label for="contactNum">Contact Number</label>
        <input type="tel" id="contactNum" name="contactNum" class="form-control" required>
        </div>
        
        <div class="mb-3">

		<label for="profilePhoto">Profile Photo</label>
        <input type="file" id="profilePhoto" name="profilePhoto" class="form-control" required>
        </div>
       
		
        <button  class="btn btn-login w-100" type="submit">Submit</button>
         </form>
 	     <div class="mt-3">
 	       <a class="text-decoration-none" href = "login">Login</a>
 	     <div>
 	  </div>
    </div>
</body>
</html>