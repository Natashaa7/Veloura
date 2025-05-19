<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Profile Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/customerProfile.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
<link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
</head>
<body class="default-page">
	<jsp:include page = "header.jsp"/>
	<div class="container">
		<div class="profile-name">
			<img src="${pageContext.request.contextPath}/resources/images/system/profile.png">
			<ul>	
				<li>CUSTOMER NAME</li>
				<li>PROFILE</li>
			</ul>
			
		</div>
		<div class="profile-info">
			<h1 style="margin-bottom: 5rem; font-size: 3rem;">PROFILE</h1>
			<form action="${pageContext.request.contextPath}/cprofile" method="post" onsubmit="return confirmUpdate(event)">
				<c:if test="${not empty message}">
				    <p class="success">${message}</p>
				</c:if>
				<c:if test="${not empty error}">
				    <p class="error">${error}</p>
				</c:if>
				<div class="radio-group">
					<span class="radio-title">TITLE</span>
					<label>
						<input type="radio" name="title" value="MR"
					         <c:if test="${customer.title eq 'MR'}">checked</c:if>> MR
					</label>
					<label>
						<input type="radio" name="title" value="MS"
					         <c:if test="${customer.title eq 'MS'}">checked</c:if>> MS
					</label>
					<label>
						<input type="radio" name="title" value="MRS"
					         <c:if test="${customer.title eq 'MRS'}">checked</c:if>> MRS
					</label>
				</div>
				<label>USERNAME</label>
				<input type="text" id="username" name="username" value="${customer.username}" placeholder="USERNAME" required>
				
				<label>FULL NAME</label>
				<input type="text" id="fullname" name="fullname" value="${customer.customerName}" placeholder="FULL NAME" required>
				
				<label>EMAIL ADDRESS</label>
				<input type="email" id="email" name="email" value="${customer.email}" placeholder="EMAIL ADDRESS" required>
				
				<label>PHONE NUMBER</label>
				<input type="tel" id="phonenumber" name="phonenumber" value="${customer.phno}" placeholder="PHONE NUMBER" required>
				
				<label>DATE OF BIRTH</label>
				<input type="date" id="birthday" name="dob" value="${customer.dob}" required>
				
				<label>PASSWORD</label>
				<input type="password" id="password" name="password" value="${customer.password}" required>
				
				<label>NEW PASSWORD</label>
				<input type="password" id="newPassword" name="newPassword" placeholder="NEW PASSWORD">
				
				<label>CONFIRM PASSWORD</label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeholder="CONFIRM PASSWORD">

				<button type="submit">SAVE CHANGES</button>
			</form>
		</div>
	</div>
	<hr>
	<jsp:include page = "footer.jsp"/>
	<script>
		// Confirm delete dialog
		function confirmUpdate(event) {
			if (!confirm("Are you sure you want to update the profile?")) {
				event.preventDefault();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>