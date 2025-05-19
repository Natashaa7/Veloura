<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>

<div id="header">
	<header class="header">
		<nav class="parallax">
			<div class="navbar">
				<p style="font-family: 'Inika'; padding-left: 70px; font-size: 50px;"><a href="home">VELOURA</a></p>
				<p style="padding-left: 180px; padding-top: 25px; font-size: 25px; margin-right:125px;">WHERE ELEGANCE MEETS ETERNAL SHINE</p>
				<ul class="logo">
					<li style="margin-left: 60px;"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/system/search.png"/></a></li>
					<li><a href="cprofile"><img src="${pageContext.request.contextPath}/resources/images/system/profilee.png"/></a></li>
					<li><a href="logout" onclick="return confirmLogout();"><img src="${pageContext.request.contextPath}/resources/images/system/logout.png"/></a></li>
				</ul>
			</div>
			<div class="navbar">
				<ul>
					<li style="margin-right:54.75rem; margin-left: 0.75rem;"><a href="products">JEWELLERY</a></li>
					<li><a href=adminDashboard>DASHBOARD</a></li>
					<li><a href="aboutus">ABOUT US</a></li>
					<li><a href="contactus">CONTACT US</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<script>
		// Confirm logout dialog
		function confirmLogout() {
			return confirm("Are you sure you want to logout?");
		}
	</script>
</div>

