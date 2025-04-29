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
	href="${pageContext.request.contextPath}/css/admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminFooter.css" />
<link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
</head>
<body class="default-page">
	<jsp:include page = "adminHeader.jsp"/>
	<section class="dashboard">
		<div class="stats">
			<div class=value>
				<p>HIGHEST RATING</p>
			</div>
			<div class=value>
				<p>MOST SALES</p>	
			</div>
		</div>
		<div class="stats">
			<div class=value-2>
				<p>MOST POPULAR</p>
			</div>
			<div>
				<div class=value-3>
					<p>UNDERRATED</p>	
				</div>
				<div class=value-3>
					<p>CUSTOMER</p>	
				</div>			
			</div>
			
		</div>
		
	</section>
	
	<hr>
	<jsp:include page = "adminFooter.jsp"/>
</body>
</html>