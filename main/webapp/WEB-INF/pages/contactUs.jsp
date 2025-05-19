<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/contactUs.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body class="default-page">
	<jsp:include page = "header.jsp"/>
	<div class="container">
		<img src="${pageContext.request.contextPath}/resources/images/system/30.png">
		<p style= "padding: 40px; margin-top: 20px; margin-left: 70px; font-size: 40px;">CONTACT US</p>
		<div class=contact>
			<div class="info">
				<p>Join us on this journey to elevate how you manage your most precious assets. 
				With Veloura, your collection isn’t just organized—it’s celebrated.</p>
				<div class="detail">
					<div class="info-2">
						<img src="${pageContext.request.contextPath}/resources/images/system/call.png">
						<p>CALL US</p>
					</div>
					<p>TEL: +44 236875643</p>
				</div>
				<div class="detail">
					<div class="info-2">
						<img src="${pageContext.request.contextPath}/resources/images/system/mail.png">
						<p>EMAIL US</p>
					</div>
					<p>SUPPORT@VELOURA.COM</p>	
				</div>
				<div class="detail">
					<div class="info-2">
						<img src="${pageContext.request.contextPath}/resources/images/system/location.png">
						<p>VISIT US</p>
					</div>
					<p>VELOURA HQ, OXFORD STREET, LONDON, UK</p>
				</div>
				
				<div class="detail">
					<div class="info-2">
						<img src="${pageContext.request.contextPath}/resources/images/system/appointment.png">
						<p>APPOINTMENT</p>
					</div>
					<p>REQUEST AN APPOINTMENT</p>	
				</div>	
				
				
			</div>
			<div class="contact-form">
				<h3 style="padding: 20px 0 25px 0;">JOIN US IN OUR JOURNEY!</h3>
				<form  id="contactForm">
					<input type="text" id="username" name="username" placeholder="FULL NAME" required>
					<input type="text" id="address" name="address" placeholder="ADDRESS" required>
					<input type="tel" id="phonenumber" name="phonenumber" placeholder="PHONE NUMBER" required>
					<textarea style="height: 10rem;" id="message" name="message" placeholder="MESSAGE (OPTIONAL)" rows="5"></textarea>	
					<button type="submit">SUBMIT</button>
				</form>
				<div class="popup" id="popupMessage">
					YOUR MESSAGE HAS BEEN SENT! <br><br> CONTACT US FOR FURTHER INFORMATION.
				</div>
				<!-- JavaScript for Pop-up -->
			    <script>
			        document.getElementById('contactForm').addEventListener('submit', function(event) {
			            event.preventDefault(); // Prevent default form submission
			
			            // Show the pop-up
			            const popup = document.getElementById('popupMessage');
			            popup.classList.add('show');
			
			            // Hide the pop-up after 3 seconds
			            setTimeout(function() {
			                popup.classList.remove('show');
			            }, 3000);
			
			            // Optionally, reset the form
			            this.reset();
			        });
			    </script>
			</div>
		</div>
	</div>

</body>
<jsp:include page = "footer.jsp"/>
</html>
