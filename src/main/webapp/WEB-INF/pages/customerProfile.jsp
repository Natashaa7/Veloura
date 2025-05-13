<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<img src="${pageContext.request.contextPath}/resources/images/system/profilee.png">
			<ul>	
				<li>CUSTOMER NAME</li>
				<li>PROFILE</li>
			</ul>
			
		</div>
		<div class="profile-info">
			<h1 style="margin-bottom: 5rem; font-size: 3rem;">PROFILE</h1>
			<form action="login" method="post">
				<div class="radio-group">
					<span class="radio-title">TITLE</span>
					<label><input type="radio" name="title" value="MR"> MR</label> 
					<label><input type="radio"name="title" value="MS"> MS</label> 
					<label><input type="radio" name="title" value="MRS"> MRS</label>
				</div>
				<label>USERNAME</label>
				<input type="text" id="username" name="username"placeholder="USERNAME" required> 
				<label>FULL NAME</label>
				<input type="text" id="fullname" name="fullname" placeholder="FULL NAME" required>
				<label>EMAIL ADDRESS</label>
				<input type="email" id="email" name="email" placeholder="EMAIL ADDRESS" required> 
				<label>PHONE NUMBER</label>
				<input type="tel" id="phonenumber" name="phonenumber" placeholder="PHONE NUMBER" required> 
				<label>DATE OF BIRTH</label>
				<input type="date" id="birthday" name="dob" placeholder="DATE OF BIRTH" required> 
				<label>PASSWORD</label>
				<input type="password" id="password" name="password" placeholder="PASSWORD" required> 
				<label>CONFIRM PASSWORD</label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeholder="CONFIRM PASSWORD" required>
				<button type="submit">SAVE CHANGES</button>
			</form>
		</div>
	</div>
	<hr>
	<jsp:include page = "footer.jsp"/>
</body>
</html>