<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>

	<div class="container">
		<div class="login">
			<h1
				style="text-align: center; padding: 20px 0 40px 0; font-size: 50px;">VELOURA</h1>
			<div class="links">
				<a href="login">REGISTERED?</a> <a href="signup">CREATE YOUR
					ACCOUNT</a>
			</div>
		</div>
		<div class="form-box">
			<h3 style="padding: 20px 0 25px 0;">REGISTERED? LOGIN HERE:</h3>
			<%
			    String successMessage = (String) request.getAttribute("success");
			    if (successMessage != null && !successMessage.isEmpty()) {
			%>
			    <p class="success-message"><%= successMessage %></p>
			<%
			    }
			%>
			<%
			    String errorMessage = (String) request.getAttribute("error");
			    if (errorMessage != null && !errorMessage.isEmpty()) {
			%>
			    <p class="credential-message"><%= errorMessage %></p>
			<%
			    }
			%>
			
			
			
			<form id="loginForm" action="login" method="post">
				<input type="text" id="username" name="username" placeholder="USERNAME" required> 
				<input type="password" id="password" name="password" placeholder="PASSWORD" required>
				<h5 style="padding: 20px 0 25px 0;">FORGOT YOUR PASSWORD?</h5>
				<button type="submit">LOGIN</button>
			</form>

			<h6>©2025 Veloura Inc. All Rights Reserved</h6>
		</div>
	</div>
	
</body>
</html>