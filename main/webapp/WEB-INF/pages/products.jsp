<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/products.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
<link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="default-page">
	<jsp:include page = "header.jsp"/>
	<div class="first-look">
		<img src="${pageContext.request.contextPath}/resources/images/system/31.jpg">
		<div class="text">
			<p>JEWELS <br> FOR <br> EVERY <br> SIDE OF <br> YOU</p> 
		</div>	
	</div>
	<section class="product">
		<div class="row">		
			<c:forEach var="p" items="${products}">
				<figure>
					<img src="${pageContext.request.contextPath}/${p.image}"/>
					<figcaption>${p.name}</figcaption>
					<p>${p.material}</p>
					<p>$${p.cost}</p>
					<div>
						<i class="fa fa-star checked"></i>
						<i class="fa fa-star checked"></i>
						<i class="fa fa-star checked"></i>
						<i class="fa fa-star checked"></i>
						<i class="fa fa-star"></i>
					</div>
					<button>BUY NOW</button>
				</figure>
			</c:forEach>	
		</div>
	</section>
	<hr>
	<jsp:include page = "footer.jsp"/>	
</body>

</html>
	