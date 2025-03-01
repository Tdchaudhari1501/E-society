<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>States</title>
</head>
<body>
 <h2>Entered State</h2>
    <table border="1">
       <tr>
			<th>State</th>
		
		</tr>
        <c:forEach items="${stateList}"  var="s">
            <tr>
                <td>${s.stateName}</td>
   
            </tr>
        </c:forEach>
    </table>
    <br>
  

</body>
</html>