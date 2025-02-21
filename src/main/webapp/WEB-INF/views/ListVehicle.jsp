<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehical List</title>
</head>
<body>
           <table border="1">
                <tr>  
                    <th>Parking Code</th>
	                <th> Vehical No</th>
	                <th> Vehical Type</th>
	                  <th>Action</th>
	           </tr>
	          <c:forEach var="v" items="${listVehical}" >
	             <tr>
	                <td>${ v.parkingCode}</td>
	                 <td>${v.vehicleNo}</td>
	                  <td>${v.vehicleType}</td>
	                  <td><a href="viewvehicle?vehicleId=${v.vehicleId}">View</a> | <a href="deletevehicle?vehicleId=${v.vehicleId}">Delete</a> | Edit </td>
	                  
	             </tr> 
	             
	          
	          </c:forEach>         
                    
                
                    
           </table>
</body>
</html>