<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visitor List</title>
</head>
<body>
           <table border="1">
                   
                <tr>  
                    <th>Purpose</th>
                    <th>Allowed</th>
                    <th>VisitorName</th>
	                <th>Mobile Number</th>
	                <th>Profile Photo</th>
	                <th>Entry Time</th>
	                <th>Exit Time</th>
	                <th>ACtion </th>
	                
	           </tr>
	          <c:forEach var="vl" items="${listVisitor}" >
	             <tr>
	                <td>${ vl.purpose}</td>
	                 <td>${vl.allowed}</td>
	                  <td>${vl.visitorName}</td>
	                  <td>${vl.mobileNo}</td>
	                  <td>${vl.profilePhoto}</td>
	                  <td>${vl.entryTime}</td>
	                  <td>${vl.exitTime}</td>
	                  <td><a href="viewvisitor?visitorId=${vl.visitorId}">View</a> | <a href="deletevisitor?visitorId=${vl.visitorId}">Delete</a> | Edit </td>
	                  
	             </tr> 
	             
	          
	          </c:forEach>         
                    
                
                    
           </table>
</body>
</html>