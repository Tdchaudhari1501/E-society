<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security List</title>
</head>
<body>
           <table border="1">
                   
                <tr>  
                    <th>Name</th>
	                <th>Contact Number</th>
	                <th> Schedule</th>
	                <th>ACtion </th>
	           </tr>
	          <c:forEach var="s" items="${listSecurity}" >
	             <tr>
	                <td>${ s.name}</td>
	                 <td>${s.contactNum}</td>
	                  <td>${s.schedule}</td>
	                  <td><a href="viewsecurity?securityId=${s.securityId}">View</a> | <a href="deletesecurity?securityId=${s.securityId}">Delete</a> | Edit </td>
	                  
	             </tr> 
	             
	          
	          </c:forEach>         
                    
                
                    
           </table>
</body>
</html>