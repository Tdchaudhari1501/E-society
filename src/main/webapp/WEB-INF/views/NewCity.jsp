<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New City</title>
</head>
<body>
	<h2>New City</h2>
	<form action="savecity" method="post">
		<br> State: 
		<select name="stateId">
			
		<option>Select State</option>
			
			<c:forEach items="${allState}" var="s">

			   <option value="${s.stateId}">${s.stateName }</option>
			
			</c:forEach>

		</select> 
		<br>
		<label for="cityName">City Name: </label>
		<input type="text" id="cityName" name="cityName">
		<br><br>

		<input type="submit" class="btn btn-primary mt-2" value="Save City">
	</form>
</body>
</html>