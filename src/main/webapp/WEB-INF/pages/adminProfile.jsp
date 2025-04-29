<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body class="default-page">
	<jsp:include page = "adminHeader.jsp"/>
	<div class="container">
		<div class="profile-name">
			<img src="${pageContext.request.contextPath}/resources/images/system/profilee.png">
			<ul>	
				<li>NATASHA SHRESTHA</li>
				<li>PROFILE</li>
			</ul>
			
		</div>
		<div class="profile-info">
			<form action="login" method="post">
				<div class="radio-group">
					<span class="radio-title">TITLE</span>
					<label><input type="radio" name="title" value="MR"> MR</label> 
					<label><input type="radio"name="title" value="MS"> MS</label> 
					<label><input type="radio" name="title" value="MRS"> MRS</label>
				</div>
				<label>USERNAME</label>
				<input type="text" id="username" name="username" required> 
				<label>FULL NAME</label>
				<input type="text" id="fullname" name="fullname" required>
				<label>EMAIL ADDRESS</label>
				<input type="email" id="email" name="email" required> 
				<label>PHONE NUMBER</label>
				<input type="tel" id="phonenumber" name="phonenumber" required> 
				<label>DATE OF BIRTH</label>
				<input type="date" id="birthday" name="dob" required> 
				<label>PASSWORD</label>
				<input type="password" id="password" name="password" required> 
				<label>CONFIRM PASSWORD</label>
				<input type="password" id="confirmPassword" name="confirmPassword" required>
				<button type="submit">UPDATE</button>
			</form>
		</div>
	</div>
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
</body>
</html>