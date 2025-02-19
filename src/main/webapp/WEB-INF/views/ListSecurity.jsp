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
	           </tr>
	          <c:forEach var="vl" items="${listSecurity}" >
	             <tr>
	                <td>${ vl.name}</td>
	                 <td>${vl.contactNum}</td>
	                  <td>${vl.schedule}</td>
	             </tr> 
	             
	          
	          </c:forEach>         
                    
                
                    
           </table>
</body>
</html>