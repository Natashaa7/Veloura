<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jewellery Dashboard Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminFooter.css" />
<link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
</head>
<body class="default-page">
	<jsp:include page = "adminHeader.jsp"/>
	<div class=jinfo>
		<h3>JEWELLERY DASHBOARD</h3>
		<table>
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Material</th>
					<th>Diamonds</th>
					<th>Gold</th>
					<th>Stock</th>
					<th>Total Cost</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Bulgari Serpenti Ring</td>
					<td>White Gold</td>
					<td>1.12</td>
					<td>18</td>
					<td>25</td>
					<td>$89,000</td>
					<td>
						<button><img src="${pageContext.request.contextPath}/resources/images/system/update.png"></button>
						<button><img src="${pageContext.request.contextPath}/resources/images/system/delete.png"></button>
						
					</td>
				</tr>
				<tr>
					<td>Bulgari Serpenti Ring</td>
					<td>White Gold</td>
					<td>1.12</td>
					<td>18</td>
					<td>25</td>
					<td>$89,000</td>
					<td>
						<button><img src="${pageContext.request.contextPath}/resources/images/system/update.png"></button>
						<button><img src="${pageContext.request.contextPath}/resources/images/system/delete.png"></button>
						
					</td>
				</tr>
				<tr>
					<td>Bulgari Serpenti Ring</td>
					<td>White Gold</td>
					<td>1.12</td>
					<td>18</td>
					<td>25</td>
					<td>$89,000</td>
					<td>
						<button><img src="${pageContext.request.contextPath}/resources/images/system/update.png"></button>
						<button><img src="${pageContext.request.contextPath}/resources/images/system/delete.png"></button>
						
					</td>
				</tr>
			</tbody>
		</table>
		<div class="form-box">
			<h3 style="padding: 20px 0 25px 0;">ADD PRODUCT</h3>
			<div style="display:flex;">
				<form action="add" method="post">
					<input type="text" id="jewellery_name" name="jewellery_name" placeholder="JEWELLERY NAME" required> 
					<input type="text" id="material" name="material" placeholder="MATERIAL" required>
					<input type="text" id="diamonds" name="diamonds" placeholder="DIAMONDS" required> 
					<input type="text" id="gold" name="gold" placeholder="GOLD" required> 
				</form>
				<form action="add" method="post">
					<input type="text" id="stock" name="stock" placeholder="STOCK" required> 
					<input type="text" id="total_cost" name="total_cost" placeholder="TOTAL COST" required> 
					<button type="submit">ADD PRODUCT</button>
				</form>
			</div>
		</div>
	</div>
	
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
</body>
</html>