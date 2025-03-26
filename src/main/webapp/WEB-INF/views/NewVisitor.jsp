
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Admin | New Visitor</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>New Visitor</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					<li class="breadcrumb-item active">New Visitor</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<form action="savevisitor" method="post">
		<label for="purpose">Purpose: </label>
		<input type="text" id="purpose" name="purpose">
		<br><br>
		
		
		
		<label for="allowed">Allowed: </label>
		<input type="text" id="allowed" name="allowed">
		<br><br>
		
		<label for="visitorName">Visitor Name: </label>
		<input type="text" id="visitorName" name="visitorName">
		<br>
		<br>
		 <br> House: 
		<select name="houseId">
			
		<option>Select House</option>
			
			<c:forEach items="${allHouse}" var="h">

			   <option value="${ h.houseId}">${h.title }</option>
			
			</c:forEach>

		</select> 
		<br><br>
		
		
		 <br> VisitorCategory: 
		<select name="visitorCategoryId">
			
		<option>Select VisitorCategory</option>
			
			<c:forEach items="${allvisitorcate}" var="h">

			   <option value="${ h.visitorCategoryId}">${h.categoryName }</option>
			
			</c:forEach>

		</select> 
		<br><br>
		
		<label for="mobileNo">Mobile No: </label>
		<input type="text" id="mobileNo" name="mobileNo">
		<br><br>
		
		<label for="profilePhoto">Profile Photo: </label>
		<input type="file" id="profilePhoto" name="profilePhoto">
		<br><br>
		
		<label for="entryTime">Entry Time: </label>
		<input type="text" id="entryTime" name="entryTime">
		<br><br>
		
		<label for="exitTime">Exit Time: </label>
		<input type="text" id="exitTime" name="exitTime">
		<br><br>
		
		<input type="submit" value="Save Visitor">
	</form>
	
		</section>

	</main>
	<!-- main content end  -->


	<jsp:include page="AdminFooter.jsp"></jsp:include>

	<jsp:include page="AdminJs.jsp"></jsp:include>
	
	

	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>

	<script type="text/javascript">

	$( document ).ready(function() {
		let table = new DataTable('#myTable');
	});
	</script>

</body>
</html>