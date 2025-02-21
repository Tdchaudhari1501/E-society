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
	           </tr>
	          <c:forEach var="vl" items="${listVehical}" >
	             <tr>
	                <td>${ vl.parkingCode}</td>
	                 <td>${vl.vehicleNo}</td>
	                  <td>${vl.vehicleType}</td>
	             </tr> 
	             
	          
	          </c:forEach>         
                    
                
                    
           </table>
</body>
</html>