

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>User | List Deliverable</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body> 

	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>List Deliverable</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
					<li class="breadcrumb-item active">List Deliverable</li>
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
										Deliverables<span>/all/</span>
									</h5>

									<table class="table datatable datatable-table table-hover"
										id="myTable">
										<thead>
											<tr>
												<th>Date</th>
												<th>IsPickUp</th>
												<th>ProductPhoto</th>
												
												<th>Action</th>
											</tr>
										</thead>

										<tbody>

											<c:forEach items="${allDeliverable}" var="d">
												<tr>
													<td>${d[0]}</td>
													<td>${d[1]}</td>
							
													<td><img alt="photo" src="${d[2]}"
														style="hight: 50px; width: 50px;"></td>
												

													<td><a href="edituserdeliverable?deliverablesId=${d[3]}">Edit</a> |<a
														href="deleteuserdeliverable?deliverablesId=${d[3]}">Delete</a>| <a
														href="viewuserdeliverable?deliverablesId=${d[3]}">View</a></td>
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