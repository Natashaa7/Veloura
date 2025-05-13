<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<div class=value>
					<p>ORDERS<i class="fa-solid fa-bag-shopping" style="margin-left: 9rem;"></i></p>
					<h1>500</h1>
				</div>
				<div class=value>
					<p>TOTAL REVENUE<i class="fa-solid fa-hand-holding-dollar" style="margin-left: 3rem;"></i></p>	
					<h1>$ 21,000</h1>
				</div>
				<div class=value>
					<p>CUSTOMERS<i class="fa-solid fa-user-group" style="margin-left: 6rem;"></i></p>	
					<h1>100</h1>
				</div>
			</div>
			<div class="stats">
				<div class=value-2>
					<p>MOST POPULAR<i class="fa-solid fa-fire" style="margin-left: 6rem;"></i></p>
					<table>
						<tbody>
							<tr>
								<td>1.</td>
								<td>BULGARI SERPENTI RING</td>
								<td>$ 89,000</td>
							</tr>
							<tr>
								<td>2.</td>
								<td>EMERALD TIFFANY RING</td>
								<td>$ 19,500</td>
							</tr>
							<tr>
								<td>3.</td>
								<td>VAN CLEEF FLORA EARRINGS</td>
								<td>$ 25,000</td>
							</tr>
							<tr>
								<td>4.</td>
								<td>FOLIE DES PRES BRACELET</td>
								<td>$ 20,900</td>
							</tr>
							<tr>
								<td>5.</td>
								<td>MAGIC ALHAMBRA BRACELET</td>
								<td>$ 19,500</td>
							</tr>
						</tbody>
					</table>
					<button>VIEW ALL PRODUCTS</button>
				</div>
				<div class=value-2>
					<p>HIGHEST RATING<i class="fa-solid fa-star-half-stroke" style="margin-left: 4rem;"></i></p>
					<table>
						<tbody>
							<tr>
								<td>1.</td>
								<td>VINTAGE ALHAMBRA PENDANT</td>
								<td>$ 22,000</td>
							</tr>
							<tr>
								<td>2.</td>
								<td>EMERALD TIFFANY RING</td>
								<td>$ 19,500</td>
							</tr>
							<tr>
								<td>3.</td>
								<td>VAN CLEEF FLORA EARRINGS</td>
								<td>$ 25,000</td>
							</tr>
							<tr>
								<td>4.</td>
								<td>FOLIE DES PRES BRACELET</td>
								<td>$ 20,900</td>
							</tr>
							<tr>
								<td>5.</td>
								<td>MAGIC ALHAMBRA BRACELET</td>
								<td>$ 19,500</td>
							</tr>
						</tbody>
					</table>	
					
				</div>
					
			</div>
		</section>
	</div>
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
		
</body>


</html>