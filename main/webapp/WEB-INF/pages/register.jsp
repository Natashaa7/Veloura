<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
	<div class="pop-up">
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
	</div>
	
	<div class="container">
		
		<div class="register">
			<h1
				style="text-align: center; padding: 20px 0 40px 0; font-size: 50px;">VELOURA</h1>
			<div class="links">
				<a href="login">REGISTERED?</a> 
				<a href="signup">CREATE YOUR ACCOUNT</a>
			</div>
		</div>
		<div class="form-box">
			<h3 style="padding: 10px 0 25px 0; text-align: left;">REQUIRED INFORMATION</h3>
			<form action="${pageContext.request.contextPath}/signup" method="post">
				
				<div class="radio-group">
					<span class="radio-title">TITLE</span>
					<label><input type="radio" name="title" value="MR"> MR</label> 
					<label><input type="radio"name="title" value="MS"> MS</label> 
					<label><input type="radio" name="title" value="MRS"> MRS</label>
				</div>
				<input type="text" id="username" name="username"placeholder="USERNAME" required> 
				<input type="text" id="fullname" name="fullname" placeholder="FULL NAME" required>
				<input type="email" id="email" name="email" placeholder="EMAIL ADDRESS" required> 
				<input type="tel" id="phonenumber" name="phonenumber" placeholder="PHONE NUMBER" required> 
				<input type="date" id="birthday" name="dob" placeholder="DATE OF BIRTH" required> 
				<input type="password" id="password" name="password" placeholder="PASSWORD" required> 
				<input type="password" id="confirmPassword" name="confirmPassword" placeholder="CONFIRM PASSWORD" required>
				<h5 style="padding: 10px 0 15px 0;">FORGOT YOUR PASSWORD?</h5>
				<button type="submit">CREATE</button>
			</form>
			<h6>©2025 Veloura Inc. All Rights Reserved</h6>
		</div>
		
	</div>
</body>
</html>