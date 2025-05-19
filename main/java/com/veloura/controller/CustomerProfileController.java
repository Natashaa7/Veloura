package com.veloura.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import com.veloura.model.CustomerModel;
import com.veloura.service.UserProfileService;
import com.veloura.util.PasswordUtil;
import com.veloura.util.ValidationUtil;

/**
 * Servlet controller for rendering the Customer Profile page.
 * 
 * This servlet handles both GET and POST requests for the `/cprofile` endpoint
 * and forwards the request to the `customerProfile.jsp` view.
 * 
 * LMU ID: 23048637
 * NAME: Natasha Babu
 */
@WebServlet(
    asyncSupported = true, 
    urlPatterns = { "/cprofile" }
)
public class CustomerProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserProfileService service;
    /**
     * Default constructor.
     * Initializes the servlet.
     */
    public CustomerProfileController() {
        super();
        this.service = new UserProfileService();
    }

    /**
     * Handles GET requests by forwarding the request to the customer profile JSP page.
     *
     * @param request  the HttpServletRequest object containing the client's request
     * @param response the HttpServletResponse object for sending the response to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during request processing
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            System.out.println("Username from session: " + username);
            CustomerModel customer = service.getUserByUsername(username);
            
            if (customer != null) {
                System.out.println("Customer loaded: " + customer.getCustomerName());
                String encryptedPassword = customer.getPassword();
                System.out.println("Encrypted from DB: " + encryptedPassword);
                String decryptedPassword = PasswordUtil.decrypt(encryptedPassword, customer.getUsername());
                System.out.println("Decrypted password: " + decryptedPassword);
                customer.setPassword(decryptedPassword);
                request.setAttribute("customer", customer);
            } else {
                System.out.println("No customer found for username");
            }
        } else {
            System.out.println("Session or username attribute is null");
        }
        request.getRequestDispatcher("WEB-INF/pages/customerProfile.jsp").forward(request, response);
    }

    /**
     * Handles POST requests for updating the customer profile.
     * Validates input, updates profile, and forwards to the profile view with messages.
     *
     * @param request  the HttpServletRequest object containing the form data
     * @param response the HttpServletResponse object for sending the response to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during request processing
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String validationErrors = validateCustomerForm(request);

	    if (validationErrors != null) {
	        request.setAttribute("error", validationErrors);
	        doGet(request, response); // Show the form again with errors
	        return;
	    }
	    
    	String username = request.getParameter("username");
	    String title = request.getParameter("title");
	    String customerName = request.getParameter("fullname");
	    String email = request.getParameter("email");
	    String phno = request.getParameter("phonenumber");
	    String dob = request.getParameter("dob");
	    String newPassword = request.getParameter("newPassword");
	    String confirmPassword = request.getParameter("confirmPassword");

	    String encryptedPassword = null;
	    boolean updatePassword = false;

	    if (newPassword != null && !newPassword.isEmpty()) {
	        if (newPassword.equals(confirmPassword)) {
	            encryptedPassword = PasswordUtil.encrypt(username, newPassword);
	            updatePassword = true;
	        } else {
	            request.setAttribute("error", "New password and confirm password do not match.");
	            doGet(request, response);
	            return;
	        }
	    }

	    boolean success = service.updateUserProfile(
	        title, username, customerName, email, phno, dob, updatePassword ? encryptedPassword : null
	    );

	    if (success) {
	        request.setAttribute("message", "Profile updated successfully.");
	    } else {
	        request.setAttribute("error", "Failed to update profile.");
	    }
	    doGet(request, response);
	}
    
    /**
     * Validates the input fields from the customer profile form.
     *
     * @param req the HttpServletRequest object containing form parameters to validate
     * @return a string of error messages if validation fails; null if valid
     */
    private String validateCustomerForm(HttpServletRequest req) {
		StringBuilder errors = new StringBuilder();
		
		String title = req.getParameter("title");
		String userName = req.getParameter("username");
		String customerName = req.getParameter("fullname");
		String email = req.getParameter("email");
		String number = req.getParameter("phonenumber");
		String dobStr = req.getParameter("dob");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");

		// Convert date of birth
		LocalDate dob;
		try {
			dob = LocalDate.parse(dobStr);
		} catch (Exception e) {
			return "Invalid date format. Please use YYYY-MM-DD.";
		}

		// Empty fields and Validation
		if (ValidationUtil.isNullOrEmpty(title))
			errors.append("Title is required.<br>");
		else if (!ValidationUtil.isValidTitle(title))
		    errors.append("Gender must be 'mr' or 'ms' or 'mrs'.<br>");
		
		if (ValidationUtil.isNullOrEmpty(userName))
		    errors.append("Username is required.<br>");
		else if (!ValidationUtil.isValidUsername(userName))
		    errors.append("Username must start with a letter and contain only letters and numbers.<br>");
		
		if (ValidationUtil.isNullOrEmpty(customerName))
		    errors.append("Full name is required.<br>");
		else if (!ValidationUtil.isValidCustomerName(customerName))
		    errors.append("Customer name must start with a letter and contain only letters and numbers.<br>");
		
		if (ValidationUtil.isNullOrEmpty(email))
		    errors.append("Email is required.<br>");
		else if (!ValidationUtil.isValidEmail(email))
		    errors.append("Invalid email format.<br>");
		
		if (ValidationUtil.isNullOrEmpty(number))
		    errors.append("Phone number is required.<br>");
		else if (!ValidationUtil.isValidPhoneNumber(number))
		    errors.append("Phone number must be 10 digits and start with 98.<br>");
		
		if (ValidationUtil.isNullOrEmpty(dobStr))
		    errors.append("Date of birth is required.<br>");
		else if (!ValidationUtil.isAgeAtLeast16(dob))
		    errors.append("You must be at least 16 years old to register.<br>");
		
		if (ValidationUtil.isNullOrEmpty(password))
		    errors.append("Password is required.<br>");
		else if (!ValidationUtil.isValidPassword(password))
		    errors.append("Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.<br>");
		
		return errors.length() == 0 ? null : errors.toString();
	}

}
