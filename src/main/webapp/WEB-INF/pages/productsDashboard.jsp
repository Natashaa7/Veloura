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
				<h1>JEWELLERY DASHBOARD</h1>
				<div class="search-box">
					<input type="text"  placeholder="Search...">
					<i class="fas fa-search"></i>
				</div>
				
			</div>
			
			
			<table class="scrollable-table">
				<thead>
					<tr>
						<th style="width: 10rem;">Product Code</th>
						<th style="width: 12rem;">Product Name</th>
						<th>Material</th>
						<th>Diamonds</th>
						<th>Gold</th>
						<th>Stock</th>
						<th>Total Cost</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach var="p" items="${products}">
				    <tr class="hover" data-code="${p.code}">
					    <td class="editable" data-field="code">${p.code}</td>
					    <td class="editable" data-field="name">${p.name}</td>
					    <td class="editable" data-field="material">${p.material}</td>
					    <td class="editable" data-field="diamond">${p.diamond}</td>
					    <td class="editable" data-field="gold">${p.gold}</td>
					    <td class="editable" data-field="stock">${p.stock}</td>
					    <td class="editable" data-field="cost">${p.cost}</td>
				
				        <td style="display: flex; gap: 10px;">
				        	<form method="post" action="${pageContext.request.contextPath}/productsDashboard">
								<input type="hidden" name="delete_id" value="${p.code}" />
								<button type="submit" name="action" value="delete">
									<i class="fa-regular fa-trash-can"></i>
								</button>
							</form>
						
							<button type="button" class="edit-btn" data-code="${p.code}">
							    <i class="fa-regular fa-pen-to-square"></i>
							</button>     	      
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

				<form action="${pageContext.request.contextPath}/productsDashboard" method="post" style="display:flex;">
					<div class="form">
						<input type="text" id="jewellery_name" name="jewellery_name" placeholder="JEWELLERY NAME" required> 
						<input type="text" id="material" name="material" placeholder="MATERIAL" required>
						<input type="text" id="diamonds" name="diamonds" placeholder="DIAMONDS" required> 
						<input type="number" id="gold" name="gold" placeholder="GOLD" required> 
					</div>
					<div class="form">
						<input type="number" id="stock" name="stock" placeholder="STOCK" required> 
						<input type="number" id="total_cost" name="total_cost" placeholder="TOTAL COST" required> 
						<button type="submit">ADD PRODUCT</button>
					</div>
				</form>	
			</div>
		</div>
	</div>
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
	<script>
		document.addEventListener("DOMContentLoaded", function () {
		    document.querySelectorAll(".edit-btn").forEach(btn => {
		        btn.addEventListener("click", function () {
		            const row = btn.closest("tr");
		            if (row.classList.contains("editing")) return;
		
		            row.classList.add("editing");
		
		            const code = row.querySelector("[data-field='code']").textContent.trim();
		            const fields = ["name", "material", "diamond", "gold", "stock", "cost"];
		            const data = {};
		
		            fields.forEach(field => {
		                const cell = row.querySelector(`[data-field='${field}']`);
		                data[field] = cell.textContent.trim();
		                cell.innerHTML = `<input type="text" name="${field}" value="${data[field]}" required>`;
		            });
		
		            // Build hidden inputs as a string
		            let hiddenInputs = fields.map(field => 
		                `<input type="hidden" name="${field}" id="hidden-${field}-${code}">`
		            ).join("");
		
		            // Replace action buttons with Save and Cancel
		            const actionCell = row.querySelector("td:last-child");
		            const originalHTML = actionCell.innerHTML;
		
		            const formHTML = `
		                <form method="post" action="${pageContext.request.contextPath}/productsDashboard">
		                    <input type="hidden" name="action" value="update">
		                    <input type="hidden" name="jewellery_id" value="${code}">
		                    ${hiddenInputs}
		                    <button type="submit" class="save-btn">Save</button>
		                    <button type="button" class="cancel-btn">Cancel</button>
		                </form>
		            `;
		            actionCell.innerHTML = formHTML;
		
		            const form = actionCell.querySelector("form");
		
		            // When form is submitted, copy values
		            form.addEventListener("submit", function () {
		                fields.forEach(field => {
		                    const inputValue = row.querySelector(`input[name='${field}']`).value;
		                    form.querySelector(`#hidden-${field}-${code}`).value = inputValue;
		                });
		            });
		
		            // Cancel button
		            actionCell.querySelector(".cancel-btn").addEventListener("click", () => {
		                fields.forEach(field => {
		                    row.querySelector(`[data-field='${field}']`).textContent = data[field];
		                });
		                actionCell.innerHTML = originalHTML;
		                row.classList.remove("editing");
		            });
		        });
		    });
		});
		</script>

	
</body>
</html>