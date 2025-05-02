<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/visitor/verify" method="post">
    <input type="text" name="mobileNo" placeholder="Visitor Mobile" required />
    <input type="text" name="otp" placeholder="Enter OTP" required />
    <button type="submit" class="btn btn-primary">Verify Entry</button>
</form>

<c:if test="${not empty verified}">
    <p class="alert alert-success">${verified}</p>
</c:if>
<c:if test="${not empty error}">
    <p class="alert alert-danger">${error}</p>
</c:if>

</body>
</html>