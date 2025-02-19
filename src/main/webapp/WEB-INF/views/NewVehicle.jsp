<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Vehicle</title>
</head>
<body>
	<h2>New Vehicle</h2>
	<form action="savevehicle" method="post">
		<label for="parkingCode">Parking Code: </label>
		<input type="text" id="parkingCode" name="parkingCode">
		<br><br>
		
		<label for="vehicleNo">Vehicle No.: </label>
		<input type="text" id="vehicleNo" name="vehicleNo">
		<br><br>
		
		<label for="vehicleType">Vehicle Type: </label>
		<input type="text" id="vehicleType" name="vehicleType">
		<br><br>
		
		<input type="submit" value="Save Vehicle">
	</form>
</body>
</html>