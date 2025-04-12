
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>ContactUs</title>

<jsp:include page="AdminCss.jsp"></jsp:include>
</head>

<body>



	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Contact</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
					<li class="breadcrumb-item">Pages</li>
					<li class="breadcrumb-item active">Contact</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section contact">

			<div class="row gy-4">

				<div class="col-xl-6">

					<div class="row">
						<div class="col-lg-6">
							<div class="info-box card">
								<i class="bi bi-geo-alt"></i>
								<h3>Address</h3>
								<p>
									A108 Adam Street,<br> GJ, VAD 384355
								</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="info-box card">
								<i class="bi bi-telephone"></i>
								<h3>Call Us</h3>
								<p>
									+91 5589554885<br>+91 6678254445
								</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="info-box card">
								<i class="bi bi-envelope"></i>
								<h3>Email Us</h3>
								<p>
									td1501@gmail.com<br>contact@gmail.com
								</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="info-box card">
								<i class="bi bi-clock"></i>
								<h3>Open Hours</h3>
								<p>
									Monday - Friday<br>9:00AM - 05:00PM
								</p>
							</div>
						</div>
					</div>

				</div>

				<div class="col-xl-6">
					<div class="card p-4">
						<form action="savecontact" method="post">
							<div class="row gy-4">

								<div class="col-md-6">
									<input type="text" name="contactName" class="form-control"
										placeholder="Your Name" required>
								</div>

								<div class="col-md-6 ">
									<input type="email" class="form-control" name="contactEmail"
										placeholder="Your Email" required>
								</div>

								<div class="col-md-12">
									<input type="text" class="form-control" name="subject"
										placeholder="Subject" required>
								</div>

								<div class="col-md-12">
									<textarea class="form-control" name="contactMessage" rows="6"
										placeholder="Message" required></textarea>
								</div>

								<div class="col-md-12 text-center">	        
									<button class="btn btn-primary w-100" type="submit">Send Message</button>
									<span class="text-sucess"> ${msg }</span>
									
								</div>

							</div>
						</form>
					</div>

				</div>

			</div>

		</section>

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<jsp:include page="UserFooter.jsp"></jsp:include>

	<jsp:include page="AdminJs.jsp"></jsp:include>




</body>

</html>