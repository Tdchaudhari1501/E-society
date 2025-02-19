<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New House</title>
</head>
<body>
	<h2>New House</h2>
	
	<form action="savehouse" method="post">
		<label for="title">Title: </label>
		<input type="text" id="title" name="title">
		<br><br>
		
		<input type="submit" value="Save Title">
	</form>
	
</body>
</html>