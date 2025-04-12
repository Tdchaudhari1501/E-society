<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>My Profile</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link
	href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css"
	rel="stylesheet" />


</head>
<body>

	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>My Profile</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
					<li class="breadcrumb-item active">My Profile</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row" style="min-height: 500px;">
				<span class="text-success">${msg }</span>
				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row">
						<!-- Reports -->
						<div class="col-12">
							<div class="card">

                              
								<div class="card-body">
									<h5 class="card-title">
										Profile<span>/${user.firstName}/</span>
									</h5>

                                      <div> <img src="${user.profilePicPath}" class="profile-img"
						           alt="Profile Image"></div>
						           <br>
									<form class="row g-3 needs-validation" action="updateprofile"
										method="post" enctype="multipart/form-data" novalidate>
										<div class="col-12">
											<label for="firstName" class="form-label">First Name</label>
											<input type="text" name="firstName" value="${user.firstName}"
												class="form-control" id="firstName" required>

										</div>
										<div class="col-12">
											<label for="lstName" class="form-label">Last Name</label> <input
												type="text" name="lastName" value="${user.lastName}"
												class="form-control" id="lastName" required>

										</div>

										<div class="col-12">
											<label for="yourEmail" class="form-label"> Email</label> <input
												type="email" id="email" name="email" value="${user.email}"
												class="form-control" required>

										</div>

										<div class="col-12">
											<label for="contactnum" class="form-label">Contact
												Number</label> <input type="tel" id="contactNum" name="contactNum"
												value="${user.contactNum}" class="form-control" required>
											<div class="invalid-feedback">Please enter your Contact
												Number!</div>
										</div>
										<div class="col-12">
											<label for="profilePhoto" class="form-label">Profile
												Photo</label> <input type="file" id="profilePic" name="profilePic"
												class="form-control" required>

										</div>
										<input type="hidden" name="userId" value="${user.userId}" />
										${error }
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">Update
												Profile</button>
										</div>

									</form>

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



	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			let table = new DataTable('#myTable');
		});
	</script>

</body>
</html>