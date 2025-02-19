<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Security</title>
</head>
<body>
	<h2>Security</h2>
	
	<form action="savesecurity" method="post">
		<label for="name">Name: </label>
		<input type="text" id="name" name="name">
		<br><br>
		
		<label for="contactNum">Contact Number: </label>
		<input type="text" id="contactNum" name="contactNum">
		<br><br>
		
		<label for="schedule">Schedule: </label>
		<input type="text" id="schedule" name="schedule">
		<br><br>
		
		<input type="submit" value="Save Security">
	</form>
</body>
</html>