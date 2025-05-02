
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>User | My Complaints</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body> 

	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>My Complaints</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
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
										Complaints<span>/all/</span>
									</h5>
								<!-- For filter data code  -->
						<!--  			<form method="get" action="mycomplaints" class="row mb-3">
								    <div class="col-md-4">
								        <label>Filter by Type</label>
								        <select name="type" class="form-control">
								            <option value="">All</option>
								            <option ${selectedType == 'Plumbing' ? 'selected' : ''}>Plumbing</option>
								            <option ${selectedType == 'Electricity' ? 'selected' : ''}>Electricity</option>
								            <option ${selectedType == 'Security' ? 'selected' : ''}>Security</option>
								            <option ${selectedType == 'Lift' ? 'selected' : ''}>Lift</option>
								        </select>
								    </div>
								
								    <div class="col-md-4">
								        <label>Filter by Status</label>
								        <select name="status" class="form-control">
								            <option value="">All</option>
								            <option ${selectedStatus == 'Pending' ? 'selected' : ''}>Pending</option>
								            <option ${selectedStatus == 'In Progress' ? 'selected' : ''}>In Progress</option>
								            <option ${selectedStatus == 'Resolved' ? 'selected' : ''}>Resolved</option>
								        </select>
								    </div>
								
								    <div class="col-md-4 align-self-end">
								        <button type="submit" class="btn btn-primary mt-2">Apply Filter</button>
								    </div>
								</form>  -->

									<table class="table datatable datatable-table table-hover"
										id="myTable">
										 <thead>
									        <tr>
									        <th>Type</th>
									        <th>Description</th>
									        <th>Date</th>
									        <th>Status</th>
									        </tr>
									    </thead>
									    <tbody>
									        <c:forEach var="c" items="${mycomplaints}">
									            <tr>
									                <td>${c.type}</td>
									                <td>${c.description}</td>
									                <td>${c.createdAt}</td>
									                 <td>
									                <!--  ${c.status}  -->
									                 <c:choose>
													        <c:when test="${c.status == 'Resolved'}">
													            <button class="badge bg-success" >${c.status}</button>
													        </c:when>
													        <c:when test="${c.status == 'In Progress'}">
													            <button class="badge bg-danger" >${c.status}</button>
													        </c:when>
													        <c:otherwise>
													            <button class="badge bg-warning text-dark" >${c.status}</button>
													        </c:otherwise>
													    </c:choose>
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