<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Deliverable</title>
</head>
<body>
	<h2>New Deliverable</h2>
	
	<form action="savedeliverable" method="post">
	     <br> House: 
		<select name="houseId">
			
		<option>Select House</option>
			
			<c:forEach items="${allHouse}" var="h">

			   <option value="${ h.houseId}">${h.title }</option>
			
			</c:forEach>

		</select> 
		<br>
		<label for="title">IsPickUp: </label>
		<input type="text" id="title" name="isPickup">
		<br><br>
		
		<input type="submit" value="Save Title">
	</form>
	
</body>
</html>