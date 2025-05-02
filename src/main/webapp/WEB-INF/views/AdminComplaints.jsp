


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Admin | My Complaints</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Manage Complaints</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					<li class="breadcrumb-item active">My Complaints</li>
				</ol>
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
										Complaints<span>/all</span>
									</h5>
			
					<table class="table datatable datatable-table table-hover" >
					    <thead>
					        <tr>
					        <th>ID</th>
					        <th>User ID</th>
					        <th>Type</th>
					        <th>Description</th>
					        <th>Status</th>
					        <th>Action</th></tr>
					    </thead>
					    <tbody>
					        <c:forEach var="c" items="${complaints}">
					            <tr>
					                <td>${c.id}</td>
					                <td>${c.userId}</td>
					                <td>${c.type}</td>
					                <td>${c.description}</td>
					                <td>${c.status}</td>
					                <td>
					                   <c:if test="${c.status != 'Resolved'}">
							                <a href="updatecomplaintstatus?id=${c.id}&status=In Progress" class="btn btn-warning btn-sm">In Progress</a>
							                <a href="updatecomplaintstatus?id=${c.id}&status=Resolved" class="btn btn-success btn-sm">Resolved</a>
							            </c:if>
							            <c:if test="${c.status == 'Resolved'}">
							                <button class="btn btn-success btn-sm" disabled>Resolved</button>
							            </c:if>
					                </td>
					            </tr>
					        </c:forEach>
					    </tbody>
					</table>
					</div>
					</div>
					</div>
					</div>
					</div>
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