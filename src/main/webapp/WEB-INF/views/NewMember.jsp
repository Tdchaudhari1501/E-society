<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEWMember</title>
</head>
<body>
    <h2>New Member</h2>
    <form action="savemember" method="post">
	    <label for="membername">MemberName: </label>
	    <input type="text" id="memberanme" name="membername">
	    
	   <br><br>
	   <label for="age">Age: </label>
	    <input type="text" id="age" name="age">
	    
	   <br><br>
	   <label for="profilePhoto">ProfilePhoto: </label>
	    <input type="file" id="profilePhoto" name="profilePhoto">
	    
	  
	   <br><br>
	   <input type="submit" value="SaveMember">
    </form>
</body>
</html>