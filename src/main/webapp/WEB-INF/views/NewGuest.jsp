<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Guest</title>
</head>
<body>
<h2>New Guest</h2>
	<form action="saveguest" method="post">
		Full Name : <input type="text" name="fullName"/> <br><Br> 
		ContactNum: <input type="text" name="contactNum"/> <br><br> 
		HouseNum :  <input type="text" name="houseNum"/><br><br> 
		DateTime :  <input type="text" name="dateTime"/><bR><br> 
		Purpose :  <input type="text" name="purpose"/><br><br> 
		Pic :  <input type="file" name="pic"/><br><Br> 
		VehicleRegNo :  <input type="text" name="vechicleRegNo"/><br><br> 
		NumberOfVisitors : <input type="text" name="NumberOfVisitors"/> <br><br> 
		
		<input type="submit" value="Save Guest"/>
	
	
	</form>
</body>
</html>