<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminDashboard.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminFooter.css" />
<link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
<script src="https://kit.fontawesome.com/6882fa3990.js" crossorigin="anonymous"></script>
</head>
<body class="default-page">
	<div style="display:flex;">
		<jsp:include page = "adminHeader.jsp"/>
		<section class="dashboard">
			<h1 style="margin: 2rem 0 2rem 4rem; font-size: 3rem;">DASHBOARD</h1>
			<hr>
			
			<div class="stats">
				<div class="popup" id="popupMessage">
					LOGGED IN SUCCESSFULLY!<br> 
				</div>
				<div class=value>
					<p>JEWELLERY STOCK<i class="fa-solid fa-bag-shopping" style="margin-left: 1.4rem;"></i></p>
					<h1>${totalJewellery}</h1>
				</div>
				<div class=value>
					<p>STOCK VALUE<i class="fa-solid fa-hand-holding-dollar" style="margin-left: 5rem;"></i></p>	
					<h1>$${totalJewelleryCost}</h1>
				</div>
				<div class=value>
					<p>CUSTOMERS<i class="fa-solid fa-user-group" style="margin-left: 6rem;"></i></p>	
					<h1>${totalCustomers}</h1>
				</div>
			</div>
			<div class="stats">
				<div class=value-2>
					<p>MOST EXPENSIVE<i class="fa-solid fa-fire" style="margin-left: 3rem;"></i></p>
					<table>
						<tbody>
							<c:forEach var="j" items="${expensiveJewels}">
								<tr>
									<td>${j.code}</td>
									<td>${j.name}</td>
									<td>$${j.cost}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<button><a href="productsDashboard">VIEW ALL PRODUCTS</a></button>
				</div>
				<div class=value-2>
					<p>RECENTLY ADDED<i class="fa-solid fa-star-half-stroke" style="margin-left: 2rem;"></i></p>
					<table>
						<tbody>
							<c:forEach var="a" items="${recentlyAdded}">
								<tr>
									<td>${a.code}</td>
									<td>${a.name}</td>
									<td>$${a.cost}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>	
					
				</div>
					
			</div>
		</section>
		<!-- JavaScript for Pop-up -->
	    <script>
		    const urlParams = new URLSearchParams(window.location.search);
		    const loginSuccess = urlParams.get('login');
		
		    if (loginSuccess === 'success') {
		        const popup = document.getElementById('popupMessage');
		        popup.classList.add('show');
		
		        setTimeout(function () {
		            popup.classList.remove('show');
		        }, 4000);
		    }
		</script>
	</div>
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
		
</body>


</html>