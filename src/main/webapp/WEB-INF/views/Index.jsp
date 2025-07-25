<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!-- Product Overview -->
<!DOCTYPE html>
<html lang="en">

<head>
  <title>E-society</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <meta name="description" content="Simplify everyday living for your housing society!">
  <meta name="google-site-verification" content="P8hqAw19_O3IT82LJYjlEsI9TDS9vMATQkZXKoe2M8E">
  <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 <link href="assets/css/styles.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
    <!-- Google AdSense -->
<script
  async
  src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-6343650725036009"
  crossorigin="anonymous"
></script>
<script>
  (adsbygoogle = window.adsbygoogle || []).push({});
</script>

    <!-- Global site tag (gtag.js) - Google Analytics -->
<script
  async
  src="https://www.googletagmanager.com/gtag/js?id=G-X1XH8HQKLS"
></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag() {
    dataLayer.push(arguments);
  }
  gtag("js", new Date());
  gtag("config", "G-X1XH8HQKLS");
</script>

  
</head>

<body>
  <nav class="navbar navbar-inverse" style="position:sticky; top:0; z-index:10">
    <div class="container" id="navbar">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
        </button>
        <a class="navbar-brand" href="/">
          <img src="assets/img/diversity.png" alt="E-Society">
        </a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav" id="navlist">
          <li><a href="#deck">Features</a></li>
          <li><a href="#stats">Demographics</a></li>
          <li><a href="#contact">Contact</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="/login">Login</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="advertisement">
    <ins class="adsbygoogle"
      data-ad-client="ca-pub-6343650725036009"
      data-ad-slot="3263921922"
      data-ad-format="auto"
      data-full-width-responsive="true"
    ></ins>
  </div>

  <section class="banner" id="banner">
    <div class="content">
      <h1 data-aos="fade-right">E-Society</h1>
      <p data-aos="fade-left">
        Simplify everyday living for your housing society. Manage accounts and payments, 
        resolve complaints and keep the community up-to-date with all that’s going on in the society.
      </p>
      <div data-aos="zoom-in">
        <a class="btn btn-success btn-md" href="/login" role="button">LOGIN</a>
        <a class="btn btn-primary btn-md" href="/signup" role="button">SIGN UP</a>
        <br>
        <a class="btn btn-info btn-md" href="/signup" role="button">REGISTER</a>
      </div>
    </div>
  </section>
  <br>
  <div class="container" id="deck">
    <div class="row">
      <div class="w3-container" style="padding:0 16px" id="about">
        <h2 class="w3-center" style="font-weight: bold;margin-top: 30px;">Why choose E-Society?</h2>
        <div class="w3-row-padding w3-center">
          <div class="w3-third" data-aos="flip-up" >
            <i class="fa fa-users w3-margin-bottom w3-jumbo w3-center"></i>
            <p class="w3-large">Simple Connectivity</p>
            <p>Give your residents an easier way to connect. New accounts created will be approved by the society administrator for activation.</p>
          </div>
          <div class="w3-third" data-aos="flip-up">
            <i class="fa fa-clipboard w3-margin-bottom w3-jumbo"></i>
            <p class="w3-large">Hassle-free Communication</p>
            <p>Get the tools you need to keep everyone on the same page, notify about the events on the digital noticeboard.</p>
          </div>
          <div class="w3-third" data-aos="flip-up">
            <i class="fa fa-file-invoice-dollar w3-margin-bottom w3-jumbo"></i>
            <p class="w3-large">Smart Money Management</p>
            <p>Residents can pay their dues online through our Integrated Payment Gateway. Instant E-Receipts is generated and their Dues get cleared off.</p>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="w3-container" style="padding:0 16px 100px" id="about">
        <div class="w3-row-padding w3-center" style="margin-top:16px">
          <div class="w3-third" data-aos="flip-down">
            <i class="fa fa-comment w3-margin-bottom w3-jumbo w3-center"></i>
            <p class="w3-large">Helpdesk Resolution</p>
            <p>Easily raise Maintenance Requests and track to Quick Closure, Provide comments & feedback.</p>
          </div>
          <div class="w3-third" data-aos="flip-down">
            <i class="fa fa-id-card w3-margin-bottom w3-jumbo"></i>
            <p class="w3-large">Emergency Contacts</p>
            <p>
              Always, be prepared for emergencies. You can configure the Emergency Number list with numbers of your local police station,
              ambulance or pharmacy; accessible to everyone.
            </p>
          </div>
          <div class="w3-third" data-aos="flip-down">
            <i class="fa fa-user-circle w3-margin-bottom w3-jumbo"></i>
            <p class="w3-large">Profile Management</p>
            <p>Provide flexibility to residents for managing and updating their user profile.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <section id="stats" class="d-flex justify-content-center w3-container" style="background-color: #1d1919;">
    <div class="content-box-md">
      <div class="container">
        <div class="row">
          <div class="col-md-12 ">
            <h2 class="w3-center" style="font-weight:bold; margin:30px 0; color: white;" data-aos="zoom-in-up">Imagine the Possibilities in a Connected Community</h2>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-md-3 col-sm-3 col-xs-6" data-aos="zoom-in-down">
            <div class="stats-item text-center">
                <i class='fas fa-city' style='font-size:36px'></i>
                <h3 class="counter">92</h3>
                <p>Cities</p>
            </div>
          </div>
          <div class="col-md-3 col-sm-3 col-xs-6" data-aos="zoom-in-down">
            <div class="stats-item text-center">
                <i class='fas fa-building' style='font-size:36px'></i>
                <h3 class="counter">133</h3>
                <p>Housing Societies</p>
            </div>
          </div>
          <div class="col-md-3 col-sm-3 col-xs-6" data-aos="zoom-in-down">
            <div class="stats-item text-center">
                <i class='fas fa-home' style='font-size:36px'></i>
                <h3 class="counter">270</h3> 
                <p>Homes</p>
            </div>
          </div>
          <div class="col-md-3 col-sm-3 col-xs-6" data-aos="zoom-in-down">
            <div class="stats-item text-center">
              <i class='fas fa-user' style='font-size:36px'></i>
              <h3 class="counter">4108</h3>
              <p>Page Visitors</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <div class="w3-container" id="contact" style="padding-bottom:100px" data-aos="fade-up" data-aos-anchor-placement="bottom-bottom">
    <h1 class="w3-center" style="font-weight: bold; margin-top: 30px; font-size: 30px;">Reach Out</h1>
    <div style="margin-top:48px; max-width:500px; margin: auto;">
      <!-- Form post not working -->
      <form action="mailto:tusharchaudhari1501@gmail.com" method="POST" enctype="text/plain">
        <p><input class="w3-input w3-border" type="text" placeholder="Name" required name="Name"></p>
        <p><input class="w3-input w3-border" type="email" placeholder="Email" required name="Email"></p>
        <p><input class="w3-input w3-border" type="text" placeholder="Message" required name="Message"></p>
        <p><button class="w3-button w3-black" type="submit" style="display: block;margin: auto;">
          <i class="fa fa-paper-plane"></i> Send Message
        </button></p>
      </form>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery.counterup@2.1.0/jquery.counterup.min.js"></script>
  <script src="assets/js/counter.js"></script>
  <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
  <script>
    AOS.init();
  </script>
  
<!-- Footer content -->
  <footer>
    <div class="container home-container footer-head">
      <div class="box">
        <h2 id="text1">About Us</h2>
        <p id="text2">
          Community management app, capable of simplifying everyday living for your housing society. 
          Manage accounts and payments, resolve complaints and keep the community up-to-date with all 
          that’s going on in the society.
        </p>
      </div>
      <div class="box">
        <h2>Get In Touch</h2>
        <div class="subcategories">
          <p id="text2">If you have any questions, please feel free to drop us a mail.</p>
          <a href="mailto:tusharchaudhari1501@gmail.com" target="_blank" style="font-size: 14px;">
            <i class="fas fa-paper-plane"></i> Send Message
          </a>
        </div>
      </div>
    </div>
    <div class="author">
      <a href="https://github.com/Tdchaudhari1501/E-Society" target="_blank">
        <i class="fab fa-github"></i>
      </a>
    </div>
  </footer>
  
  <script type="text/javascript">
    $(document).ready(function () {
      let url = window.location;
      $('ul.nav a').filter(function() {
        return this.href == url;
      }).parent().addClass('active');
    });
  </script> 
</body>

</html>  