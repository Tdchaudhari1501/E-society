<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Security | List Visitor</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<aside id="sidebar" class="sidebar">

	<ul class="sidebar-nav" id="sidebar-nav">

		<li class="nav-item"><a class="nav-link " href="#">
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
			<h1>List Visitor</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="guard-dashboard">Home</a></li>
					<li class="breadcrumb-item active">List Visitor</li>
				</ol>
				<h1>Welcome, Security Guard</h1>

				
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row" style="min-height: 500px;">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row">
						<!-- Reports -->
						<div class="col-12">
							<div class="card">


								<div class="card-body">
									<h5 class="card-title">
										Visitors<span>/all</span>
									</h5>


									<table class="table datatable datatable-table table-hover" id="myTable">
										 
									    <thead><tr><th>Name</th><th>Email</th><th>Status</th><th>Entry</th><th>Exit</th><th>Action</th></tr></thead>
									    <tbody>
									        <c:forEach var="v" items="${visitors}">
									            <tr>
									                <td>${v.visitorName}</td>
									                <td>${v.mobileNo}</td>
									                <td>
									                    <c:choose>
									                        <c:when test="${v.allowed == 1}">✅ Approved</c:when>
									                        <c:otherwise>⏳ Pending</c:otherwise>
									                    </c:choose>
									                </td>
									                <td>${v.entryTime}</td>
									                <td>${v.exitTime}</td>
									                <td>
									                    <a href="verifyvisitorotp?visitorId=${v.visitorId}" class="btn btn-success btn-sm">Approve</a>
									                    <a href="entryexit?visitorId=${v.visitorId}&type=entry" class="btn btn-info btn-sm">Entry</a>
									                    <a href="entryexit?visitorId=${v.visitorId}&type=exit" class="btn btn-danger btn-sm">Exit</a>
									                </td>
									            </tr>
									        </c:forEach>
									    </tbody>
									</table>
									



								</div>

							</div>
						</div>
						<!-- End Reports -->

					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->
				<!-- End Right side columns -->

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