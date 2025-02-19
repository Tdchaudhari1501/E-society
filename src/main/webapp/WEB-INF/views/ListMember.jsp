<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
           <table border="1">
                   
                <tr>  
                    <th>Member Name</th>
	                <th> Age</th>
	                <th> Profile Photo</th>
	           </tr>
	          <c:forEach var="vl" items="${listMember}" >
	             <tr>
	                <td>${ vl.membername}</td>
	                 <td>${vl.age}</td>
	                  <td>${vl.profilePhoto}</td>
	             </tr> 
	             
	          
	          </c:forEach>         
                    
                
                    
           </table>
</body>
</html>