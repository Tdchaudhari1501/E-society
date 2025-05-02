


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Admin | Edit Visitor</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Edit Visitor</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					<li class="breadcrumb-item active">Edit Visitor</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<form action="updatevisitor" method="post">
 		Purpose : <input type="text" name="purpose" value="${visitor.purpose}" /><br> <br>
 		Allowed : <input type="text" name="allowed" value="${visitor.allowed}" /><br> <br>
 		VisitorName: <input type="text" name="visitorName" value="${visitor.visitorName}" /><br> <br>
 		Mobile No: <input type="text" name="mobileNo" value="${visitor.mobileNo}" /><br> <br>
 		EntryTime: <input type="text" name="entryTime" value="${visitor.entryTime}" /><br> <br>
 		ExitTime: <input type="text" name="exitTime" value="${visitor.exitTime}" /><br> <br>
 		
 			
 		<input type="hidden" name="visitorId"  value="${visitor.visitorId}"/>
 		
 		<input type="submit" class="btn btn-primary mt-2" value="Update Visitor" />
 	</form>
			</div>
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