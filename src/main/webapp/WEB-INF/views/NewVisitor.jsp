<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Visitor</title>
</head>
<body>
	<h2>New Visitor</h2>
	
	<form action="savevisitor" method="post">
		<label for="purpose">Purpose: </label>
		<input type="text" id="purpose" name="purpose">
		<br><br>
		
		
		
		<label for="allowed">Allowed: </label>
		<input type="text" id="allowed" name="allowed">
		<br><br>
		
		<label for="visitorName">Visitor Name: </label>
		<input type="text" id="visitorName" name="visitorName">
		<br><br>
		
		<label for="mobileNo">Mobile No: </label>
		<input type="text" id="mobileNo" name="mobileNo">
		<br><br>
		
		<label for="profilePhoto">Profile Photo: </label>
		<input type="file" id="profilePhoto" name="profilePhoto">
		<br><br>
		
		<label for="entryTime">Entry Time: </label>
		<input type="text" id="entryTime" name="entryTime">
		<br><br>
		
		<label for="exitTime">Exit Time: </label>
		<input type="text" id="exitTime" name="exitTime">
		<br><br>
		
		<input type="submit" value="Save Visitor">
	</form>
	
</body>
</html>