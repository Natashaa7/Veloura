<div id="header">
	<header class="header">
		<div class="parallax">
			<div class="navbar">
				<p style="font-family: 'Inika'; padding: 30px; font-size: 50px; "><a href="adminDashboard" style="color: white;">VELOURA</a></p>
				<p style="font-size: 15px; margin-bottom: 20px;">WHERE ELEGANCE MEETS ETERNAL SHINE</p> 
				
			</div>
			<div class="navbar">
				<nav>
					<a href="adminDashboard" class="redirect"><i class="fa-brands fa-square-letterboxd"></i>DASHBOARD</a>
					<a href="productsDashboard" class="redirect"><i class="fa-solid fa-gem"></i>JEWELLERY</a>
					<a href="aboutus" class="redirect"><i class="fa-solid fa-users"></i>ABOUT US</a>
					<a href="contactus" class="redirect"><i class="fa-regular fa-address-book"></i>CONTACT US</a>
					<a href="aprofile" class="redirect"><i class="fa-regular fa-circle-user"></i>PROFILE</a>
					<a href="logout" class="redirect" onclick="return confirmLogout();"><i class="fa-solid fa-arrow-right-from-bracket"></i>LOGOUT</a>
				</nav>
			</div>
		</div>
	</header>
	<script>
		// Confirm logout dialog
		function confirmLogout() {
			return confirm("Are you sure you want to logout?");
		}
	</script>

</div>

