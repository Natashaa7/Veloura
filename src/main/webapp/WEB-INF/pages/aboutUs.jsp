<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/aboutUs.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body class="default-page">
	<jsp:include page = "header.jsp"/>
	<div class="container">
		<p style= "padding: 40px; margin-left: 60px; font-size: 40px;">ABOUT US</p>
		<div class="first-half">
			<p>At Veloura, we believe that jewellery is more than just an accessory — it’s an expression of who you are. 
			For years, we’ve earned the trust of our customers by offering jewellery that not only reflects the highest standards of 
			craftsmanship and authenticity but also truly connects with their personal needs. 
			Our pieces are crafted to fit seamlessly into your life, whether you’re looking for a subtle, 
			minimal design to elevate your everyday look or a bold, high jewellery piece to make a statement. 
			We are committed to providing a seamless experience from start to finish, which is why our loyal customers 
			continue to choose us year after year. We listen to their needs, ensure every detail meets their expectations, 
			and deliver pieces that bring both beauty and confidence. 
			With meticulous care in our craftsmanship and an unwavering dedication to quality, 
			each design tells a unique story, built on the foundation of our passion for perfection and customer satisfaction.</p>
			<img src="${pageContext.request.contextPath}/resources/images/system/27.jpg">
		</div>
		<img src="${pageContext.request.contextPath}/resources/images/system/28.jpg">
		<div class="second-half">
			<img src="${pageContext.request.contextPath}/resources/images/system/29.png">
			<p>Our employees play a crucial role in upholding the values we stand by. 
			Each member of our team is driven by a shared commitment to excellence and a passion for creating jewellery 
			that’s not only beautiful but enduring. We take immense pride in our work, whether it's crafting minimalist, 
			everyday pieces or intricate high jewellery that exudes luxury and sophistication. 
			Every piece is made with the finest materials, from ethically sourced stones to durable metals, 
			ensuring that your jewellery will stand the test of time. Whether you're searching for the simplicity of minimalism 
			or the elegance of bold statement pieces, Veloura offers designs that cater to every individual, for every occasion. 
			Just like our customers, we are constantly striving for more — and our jewellery reflects that ambition. 
			It’s more than just a piece of jewellery; it’s a reflection of a lifestyle of confidence, authenticity, and elegance.</p>
			
		</div>
	</div>
	<jsp:include page = "footer.jsp"/>
</body>
</html>