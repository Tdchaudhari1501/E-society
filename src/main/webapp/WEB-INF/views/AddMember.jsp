
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>User | New Member</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>New Member</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
					<li class="breadcrumb-item active">New Member</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<form action="addmember" method="post" enctype="multipart/form-data">
	    <label for="membername">MemberName: </label>
	    <input type="text" id="memberanme" name="membername">
	    
	   <br><br>
	   <label for="age">Age: </label>
	    <input type="text" id="age" name="age">
	    <br> House: 
		<select name="houseId">
			
		<option>Select House</option>
			
			<c:forEach items="${allHouse}" var="h">

			   <option value="${ h.houseId}">${h.title }</option>
			
			</c:forEach>

		</select> 
		<br>
	   <br><br>
	   <label for="profilePhoto">ProfilePhoto: </label>
	    <input type="file" id="profilePhoto" name="profilePic">

	   <br><br>
	   <input type="submit" class="btn btn-primary mt-2" value="SaveMember">
    </form>
		</section>

	</main>
	<!-- main content end  -->


	<jsp:include page="UserFooter.jsp"></jsp:include>

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