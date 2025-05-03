


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Guard |Otp Verification</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<aside id="sidebar" class="sidebar">

	<ul class="sidebar-nav" id="sidebar-nav">

		<li class="nav-item"><a class="nav-link " href="guard-dashboard">
				<i class="bi bi-grid"></i> <span>Dashboard</span>
		</a></li>
		<!-- End Dashboard Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-person"></i><span>Manage Visitors</span><i
				class="bi bi-chevron-down ms-auto"></i>
		</a>
			<ul id="components-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="verifyvisitorotp"> <i class="bi bi-circle"></i><span>OTP Verification
							</span>
				</a></li>
				<li><a href="guard-dashboard"> <i class="bi bi-circle"></i><span>Entry Exit Logs
							</span>
				</a></li>
				
			</ul></li>
		<!-- End Components Nav -->
		
		</ul>

</aside>
	

	<main id="main" class="main">

		<div class="pagetitle">
			
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="guard-dashboard">Home</a></li>
					
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<h3>OTP Verification</h3>
					<form action="verifyvisitorotp" method="post">
					    <label>Email</label>
					    <input name="mobileNo" class="form-control" required>
					    <label>Enter OTP</label>
					    <input name="otp" class="form-control" required>
					    <button class="btn btn-primary mt-2">Verify</button>
					
					</form>
					<c:if test="${not empty message}">
					    <div class="alert alert-info mt-2">${message}</div>
					</c:if>
					 
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