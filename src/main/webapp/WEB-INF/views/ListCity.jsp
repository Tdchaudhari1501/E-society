<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List City</title>
</head>
<body>
	<h2>List City</h2>

	<table border="1">

		<tr>
			<th>City Name</th>
			<th>State Name</th>
		</tr>
		<c:forEach items="${allCity}" var="c">
			<tr>
				<td>${c.cityName}</td>
				<td>${c.stateName}</td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>