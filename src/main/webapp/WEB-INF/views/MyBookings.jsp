

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>User | Facility Bookings</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body> 

	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>My Facility Bookings</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
					<li class="breadcrumb-item active"> My Facility Bookings</li>
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
										My facility Bookings<span>/all/</span>
									</h5>

									<table class="table datatable datatable-table table-hover" id="myTable">
								    <thead>
								        <tr><th>Facility</th><th>Date</th><th>Time</th><th>Status</th></tr>
								    </thead>
								    <tbody>
								        <c:forEach var="b" items="${mybookings}">
								            <tr>
								                <td>${b.facilityName}</td>
								                <td>${b.bookingDate}</td>
								                <td>${b.startTime} - ${b.endTime}</td>
								                <td>
								                <!--${b.status}-->
								                    <c:choose>
											        <c:when test="${b.status == 'Approved'}">
											            <span class="badge bg-success">${b.status}</span>
											        </c:when>
											        <c:when test="${b.status == 'Rejected'}">
											            <span class="badge bg-danger">${b.status}</span>
											        </c:when>
											        <c:otherwise>
											            <span class="badge bg-warning text-dark">${b.status}</span>
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