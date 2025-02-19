<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VisitorCategory List</title>
</head>
<body>
           <table border="1">
                   
                <tr>  
                    <th>Title</th>
	               
	           </tr>
	          <c:forEach var="vl" items="${listVisitorCategory}" >
	             <tr>
	                <td>${ vl.categoryName}</td>
	                 
	             </tr> 
	             
	          
	          </c:forEach>         
                    
                
                    
           </table>
</body>
</html>