<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body class="home-page">
	<jsp:include page = "header.jsp"/>
	<div>
		<div>
			<div class="popup" id="popupMessage">
				LOGGED IN SUCCESSFULLY!<br> 
			</div>	
			<img src="${pageContext.request.contextPath}/resources/images/system/18.jpg">
			
			<div class="home">
				<p>ELEGANCE IN MOTION</p>
				<p style="font-size:15px; margin-top: 30px; margin-bottom: 30px; text-align: center;">DESIGNED FOR YOUR EVERY MOMENT - EFFORTLESS ELEGANCE THAT FLOWS WITH YOUR LIFE.</p>
				<a href="products"><button>EXPLORE THE COLLECTION</button></a>
			</div>	
			
		</div>
		<div class="highj">
			<img src="${pageContext.request.contextPath}/resources/images/system/19.png">
			<img src="${pageContext.request.contextPath}/resources/images/system/20.png">
			<img src="${pageContext.request.contextPath}/resources/images/system/21.png">
		</div>
		
		<p style="text-align:center; font-size: 40px;">FROM  DELICATE  RINGS  TO  STATEMENT  NECKLACES</p>
		<div class="category">
			<div class="jimage">
				<img src="${pageContext.request.contextPath}/resources/images/system/22.png">
				<div class="overlay-text">
					<a href="products">RING</a>
				</div>
			</div>
			<div class="jimage">
				<img src="${pageContext.request.contextPath}/resources/images/system/23.png">
				<div class="overlay-text">
					<a href="products">EARRINGS</a>
				</div>
			</div>
			<div class="jimage">
				<img src="${pageContext.request.contextPath}/resources/images/system/24.png">
				<div class="overlay-text">
					<a href="products">BRACELET</a>
				</div>
			</div>
			<div class="jimage">
				<img src="${pageContext.request.contextPath}/resources/images/system/25.png">
				<div class="overlay-text">
					<a href="products">NECKLACE</a>
				</div>
			</div>
		</div>
		<div class="last">
			<img src="${pageContext.request.contextPath}/resources/images/system/26.png">
		</div>
		<div class="category">
			<div class="service">
				<img src="${pageContext.request.contextPath}/resources/images/system/delivery.png">
				<div class="service-text">
					<p>COMPLIMENTARY SHIPPING</p>
				</div>
			</div>
			<div class="service">
				<img src="${pageContext.request.contextPath}/resources/images/system/wrap.png">
				<div class="service-text">
					<p>FREE GIFT WRAPPING</p>
				</div>
			</div>
			<div class="service">
				<img src="${pageContext.request.contextPath}/resources/images/system/engrave.png">
				<div class="service-text">
					<p>FREE ENRGAVING</p>
				</div>
			</div>
			<div class="service">
				<img src="${pageContext.request.contextPath}/resources/images/system/refund.png">
				<div class="service-text">
					<p>EASY REFUND AND EXCHANGE</p>
				</div>
			</div>
		</div>
		<!-- JavaScript for Pop-up -->
	    <script>
		    const urlParams = new URLSearchParams(window.location.search);
		    const loginSuccess = urlParams.get('login');
		
		    if (loginSuccess === 'success') {
		        const popup = document.getElementById('popupMessage');
		        popup.classList.add('show');
		
		        setTimeout(function () {
		            popup.classList.remove('show');
		        }, 4000);
		    }
		</script>
	</div>
	<jsp:include page = "footer.jsp"/>
</body>
</html>