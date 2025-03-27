<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User| List Visitors</title>
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>List Visitor</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
					<li class="breadcrumb-item active">List Visitor</li>
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
										Visitors<span>/all/</span>
									</h5>

									<table class="table datatable datatable-table table-hover"
										id="myTable">
										<thead>
											<tr>
												<th>Purpose</th>
												<th>allowed</th>
												<th>visitorName</th>
												<th>mobileNo</th>
												<th>profilePhoto</th>
												<th>Date</th>
												<th>entryTime</th>
												<th>exitTime</th>
												<th>Action</th>
											</tr>
										</thead>

										<tbody>

											<c:forEach items="${allVisitor}" var="v">
												<tr>
													<td>${v[1]}</td>
													<td>${v[2]}</td>
													<td>${v[0]}</td>
													<td>${v[5]}</td>
													<td><img alt="photo" src="${v[6]}"
														style="hight: 50px; width: 50px;"></td>
													<td>${v[7]}</td>
													<td>${v[3]}</td>
													<td>${v[4]}</td>

													<td><a href="edituservisitor?visitorId=${v[8]}">Edit</a> |<a
														href="deleteuservisitor?visitorId=${v[8]}">Delete</a>| <a
														href="viewuservisitor?visitorId=${v[8]}">View</a></td>
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
	<!-- End of main -->

	<jsp:include page="UserFooter.jsp"></jsp:include>

	<jsp:include page="AdminJs.jsp"></jsp:include>
</body>


</html>