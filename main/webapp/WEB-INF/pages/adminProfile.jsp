<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Profile Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminProfile.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminFooter.css" />
<link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
<script src="https://kit.fontawesome.com/6882fa3990.js" crossorigin="anonymous"></script>
</head>
<body class="default-page">
	<div style="display:flex;">
		<jsp:include page = "adminHeader.jsp"/>
		<div class="container">
			<div class="profile-name">
				<img src="${pageContext.request.contextPath}/resources/images/system/Natasha.png">
				<ul>	
					<li>NATASHA SHRESTHA</li>
					<li>PROFILE</li>
				</ul>
			</div>
			
			<div class="profile-info">
				<h1 style="margin-bottom: 5rem; font-size: 3rem;">PROFILE</h1>
				<form action="${pageContext.request.contextPath}/aprofile" method="post" onsubmit="return confirmUpdate(event)">
					<c:if test="${not empty message}">
					    <p class="success">${message}</p>
					</c:if>
					<c:if test="${not empty error}">
					    <p class="error">${error}</p>
					</c:if>
					<div class="radio-group">
						<span class="radio-title">TITLE</span>
						<label>
							<input type="radio" name="title" value="MR" ${admin.title == 'MR' ? 'checked' : ''}> MR
						</label>
						<label>
							<input type="radio" name="title" value="MS" ${admin.title == 'MS' ? 'checked' : ''}> MS
						</label>
						<label>
							<input type="radio" name="title" value="MRS" ${admin.title == 'MRS' ? 'checked' : ''}> MRS
						</label>
					</div>
					<label>USERNAME</label>
					<input type="text" id="username" name="username" value="${admin.username}" placeholder="USERNAME" required>
					
					<label>FULL NAME</label>
					<input type="text" id="fullname" name="fullname" value="${admin.customerName}" placeholder="FULL NAME" required>
					
					<label>EMAIL ADDRESS</label>
					<input type="email" id="email" name="email" value="${admin.email}" placeholder="EMAIL ADDRESS" required>
					
					<label>PHONE NUMBER</label>
					<input type="tel" id="phonenumber" name="phonenumber" value="${admin.phno}" placeholder="PHONE NUMBER" required>
					
					<label>DATE OF BIRTH</label>
					<input type="date" id="birthday" name="dob" value="${admin.dob}" required>
					
					<label>PASSWORD</label>
					<input type="password" id="password" name="password" value="${admin.password}" required>
					
					<label>NEW PASSWORD</label>
					<input type="password" id="newPassword" name="newPassword" placeholder="NEW PASSWORD">
					
					<label>CONFIRM PASSWORD</label>
					<input type="password" id="confirmPassword" name="confirmPassword" placeholder="CONFIRM PASSWORD">
	
					<button type="submit">SAVE CHANGES</button>
				</form>
			</div>
		</div>
	</div>
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
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