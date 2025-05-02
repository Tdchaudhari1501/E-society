<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New State</title>
</head>
<body>
   <form action="savestate" method="post">
        StateName: <input type="text" id="state" name="stateName" required>

        <button type="submit" class="btn btn-primary mt-2">Submit</button>
        
       
    </form>
</body>
</html>