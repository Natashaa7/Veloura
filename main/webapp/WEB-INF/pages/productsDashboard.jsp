<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jewellery Dashboard Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/productsDashboard.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminFooter.css" />
<link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
<script src="https://kit.fontawesome.com/6882fa3990.js" crossorigin="anonymous"></script>
</head>
<body class="default-page">
	<div style="display:flex;">
		<jsp:include page = "adminHeader.jsp"/>
		<div class="jinfo">
			<div style="display: flex;">
				<h1 style="margin-top: 30px;">JEWELLERY DASHBOARD</h1>
				<form action="${pageContext.request.contextPath}/productsDashboard" method="get" class="search-box">
					<input type="text"  name="search" placeholder="Search..." value="${param.search}">
					<button type="submit"><i class="fas fa-search"></i></button>
                </form>
				
			</div>
			
			<table class="scrollable-table">
				<thead>
					<tr>
						<th style="width: 9rem;">Product Code</th>
						<th style="width: 12rem;">Product Name</th>
						<th>Material</th>
						<th>Diamonds</th>
						<th>Gold</th>
						<th>Stock</th>
						<th style="width: 9rem;">Total Cost</th>
						<th>Image</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach var="p" items="${products}">
				    <tr>
				        <form method="post" action="${pageContext.request.contextPath}/productsDashboard" onsubmit="return confirmUpdate(event)">
				            <input type="hidden" name="update_id" value="${p.code}" />
				            <input type="hidden" name="action" value="update" />
				            <td style="width: 9rem;"><input name="code" value="${p.code}" readonly></td>
				            <td style="width: 12rem;"><input name="name" value="${p.name}"></td>
				            <td style="width: 7rem;"><input name="material" value="${p.material}"></td>
				            <td style="width: 7rem;"><input name="diamond" value="${p.diamond}"></td>
				            <td style="width: 7rem;"><input name="gold" value="${p.gold}"></td>
				            <td style="width: 7rem;"><input name="stock" value="${p.stock}"></td>
				            <td style="width: 7rem;"><input name="cost" value="${p.cost}"></td>
				            <td style="width: 6rem;"><img style="width: 70px; height: 70px;" src="${pageContext.request.contextPath}/${p.image}"></td>
				            <td style="padding-top: 32px; padding-bottom: 30px;">
				                <!-- Update button submits this form -->
				                <div class="edit">
				                	<button type="submit">
					                    <i class="fa-regular fa-pen-to-square"></i>
					                </button>
				                </div>
				                
				            </td>
				        </form>
				        <td style="padding-top: 32px; padding-bottom: 30px; margin: 0;">
				            <form method="post" action="${pageContext.request.contextPath}/productsDashboard" onsubmit="return confirmDelete(event)">
				                <input type="hidden" name="delete_id" value="${p.code}" />
				                <input type="hidden" name="action" value="delete" />
				                <button type="submit">
				                    <i class="fa-regular fa-trash-can"></i>
				                </button>
				            </form>
				        </td>
				    </tr>
				</c:forEach>

			</table>
			<div class="form-box">
				<h3 style="padding: 20px 0 25px 50px; color: white;">ADD PRODUCT</h3>
				<%
					String errorMessage = (String) request.getAttribute("error");
					String successMessage = (String) request.getAttribute("success");
				
					if (errorMessage != null && !errorMessage.isEmpty()) {
				%>
					<p class="error-message"><%= errorMessage %></p>
				<%
					}
				
					if (successMessage != null && !successMessage.isEmpty()) {
				%>
					<p class="success-message"><%= successMessage %></p>
				<%
					}
				%>

				<form action="${pageContext.request.contextPath}/productsDashboard" method="post" enctype="multipart/form-data" style="display:flex;">
					<div class="form">
						<input type="text" id="jewellery_name" name="jewellery_name" placeholder="JEWELLERY NAME" required> 
						<input type="text" id="material" name="material" placeholder="MATERIAL" required>
						<input type="text" id="diamonds" name="diamonds" placeholder="DIAMONDS" required> 
						<input type="number" id="gold" name="gold" placeholder="GOLD" required> 
					</div>
					<div class="form">
						<input type="number" id="stock" name="stock" placeholder="STOCK" required> 
						<input type="number" id="total_cost" name="total_cost" placeholder="TOTAL COST" required> 
						<input type="file" id="image" name="image" placeholder="IMAGE" required>

						<button type="submit">ADD PRODUCT</button>
					</div>
				</form>	
			</div>
		</div>
	</div>
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
	
	<!-- Pop-up to confirm delete -->
	<script>
		// Confirm delete dialog
		function confirmDelete(event) {
			if (!confirm("Are you sure you want to delete this product?")) {
				event.preventDefault();
				return false;
			}
			return true;
		}
		function confirmUpdate(event) {
			if (!confirm("Are you sure you want to update this product?")) {
				event.preventDefault();
				return false;
			}
			return true;
		}
	</script>
	
</body>
</html>