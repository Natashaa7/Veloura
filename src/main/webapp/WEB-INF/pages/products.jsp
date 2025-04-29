<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style>
	.checked {
		color: #B1B1B1;
}
</style>
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
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/9.png">
				<figcaption>GARRAD SAPPHIRE CUT DIAMOND RING</figcaption>
				<p>WHITE GOLD, SAPPHIRE, DIAMOND</p>
				<p>$ 20,900</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/10.png">
				<figcaption>GARRAD RUBY CUT DIAMOND RING</figcaption>
				<p>WHITE GOLD, RUBY</p>
				<p>$ 22,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/11.png">
				<figcaption>GARRAD PINK DIAMOND RING</figcaption>
				<p>SILVER, PINK DIAMOND</p>
				<p>$ 25,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/12.png">
				<figcaption>EMERALD TIFFANY RING</figcaption>
				<p>EMERALD, DIAMOND</p>
				<p>$ 19,500</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
		</div>
		<div class="row">
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/16.png">
				<figcaption>JEAN SCHLUMBERGER SAPPHIRE EARRINGS</figcaption>
				<p>SILVER, SAPPHIRE</p>
				<p>$ 17,800</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/13.png">
				<figcaption>VINTAGE ALHAMBRA EARRINGS</figcaption>
				<p>WHITE GOLD, DIAMOND</p>
				<p>$ 22,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/14.png">
				<figcaption>VAN CLEEF FLORA EARRINGS</figcaption>
				<p>YELLOW GOLD, PINK DIAMOND</p>
				<p>$ 25,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/15.png">
				<figcaption>MAGIC ALHAMBRA EARRINGS</figcaption>
				<p>YELLOW GOLD, DIAMOND, MALACHITE</p>
				<p>$ 19,500</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
		</div>
		<div class="row">
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/5.png">
				<figcaption>FOLIE DES PRES BRACELET</figcaption>
				<p>WHITE GOLD, SAPPHIRE, DIAMOND</p>
				<p>$ 20,900</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/6.png">
				<figcaption>VINTAGE ALHAMBRA BRACELET</figcaption>
				<p>WHITE GOLD, SAPPHIRE, DIAMOND</p>
				<p>$ 22,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/7.png">
				<figcaption>GRAIN DE CAFE BRACELET</figcaption>
				<p>YELLOW GOLD, DIAMOND</p>
				<p>$ 25,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/8.png">
				<figcaption>MAGIC ALHAMBRA BRACELET</figcaption>
				<p>WHITE GOLD, CHALCEDONY, MOTHER-OF-PEARL</p>
				<p>$ 19,500</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
		</div>
		<div class="row">
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/2.png">
				<figcaption>SAPPHIRE SERPENTI NECKLACE</figcaption>
				<p>WHITE GOLD, SAPPHIRE, DIAMOND</p>
				<p>$ 20,900</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/4.png">
				<figcaption>VINTAGE ALHAMBRA PENDANT</figcaption>
				<p>SILVER, DIAMOND</p>
				<p>$ 22,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/3.png">
				<figcaption>EMERALD SERPENTI NECKLACE</figcaption>
				<p>WHITE GOLD, EMERALD, DIAMOND</p>
				<p>$ 25,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/1.png">
				<figcaption>EMERALD DIAMOND NECKLACE</figcaption>
				<p>WHITE GOLD, SAPPHIRE, DIAMOND</p>
				<p>$ 19,500</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
		</div>
		<div class="panther">
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/22.png">
				<figcaption>PANTHERE DE CARTIER RING</figcaption>
				<p>YELLOW GOLD, EMERALD, DIAMOND</p>
				<p>$ 34,700</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/23.png">
				<figcaption>PANTHERE DE CARTIER BRACELET</figcaption>
				<p>YELLOW GOLD, EMERALD, DIAMOND</p>
				<p>$ 47,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/24.png">
				<figcaption>PANTHERE DE CARTIER PENDANT</figcaption>
				<p>YELLOW GOLD, EMERALD, DIAMOND</p>
				<p>$ 30,000</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
			<figure>
				<img src="${pageContext.request.contextPath}/resources/images/system/25.png">
				<figcaption>PANTHERE DE CARTIER EARRINGS</figcaption>
				<p>YELLOW GOLD, EMERALD, DIAMOND</p>
				<p>$ 40,500</p>
				<div>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span>
				</div>
				<button>BUY NOW</button>
			</figure>
		</div>
	</section>
	<hr>
	<jsp:include page = "footer.jsp"/>	
</body>

</html>
	