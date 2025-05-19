package com.veloura.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.veloura.util.PasswordUtil;
import com.veloura.util.ValidationUtil;
import com.veloura.model.CustomerModel;
import com.veloura.service.RegisterService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * LMU ID: 23048637
 * NAME: NATASHA BABU
 * RegisterController handles user registration requests and processes form
 * submissions. It also manages file uploads and account creation.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/signup" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterService service;

	/**
	 * Constructor that initializes the RegisterService.
	 */
	public RegisterController() {
		super();
		this.service = new RegisterService();
	}

	/**
	 * Handles GET requests by forwarding to the registration page.
	 * 
	 * @param req the HttpServletRequest
	 * @param resp the HttpServletResponse
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req, resp);
	}

	/**
	 * Handles POST requests by validating the registration form, extracting the
	 * customer model, and processing the registration.
	 * 
	 * @param req the HttpServletRequest
	 * @param resp the HttpServletResponse
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Validate and extract customer model
			String validationMessage = validateRegistrationForm(req);
			if (validationMessage != null) {
				handleError(req, resp, validationMessage);
				return;
			}

			CustomerModel customerModel = extractCustomerModel(req);
			Boolean isRegistered = service.registerCustomer(customerModel);
			if (isRegistered == null) {
				handleError(req, resp, "Our server is under maintenance. Please try again later!");
			} else if (isRegistered) {
				handleSuccess(req, resp, "Your account is successfully created!", "/WEB-INF/pages/login.jsp");
			} else {
				handleError(req, resp, "Could not register your account. Please try again later!");
			}
		} catch (Exception e) {
			handleError(req, resp, "An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
	}

	/**
	 * Validates the registration form fields.
	 * 
	 * @param req the HttpServletRequest containing the form data
	 * @return a validation message if any errors are found, or null if no errors
	 */
	private String validateRegistrationForm(HttpServletRequest req) {
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
		
		if (ValidationUtil.isNullOrEmpty(confirmPassword))
		    errors.append("Please retype/confirm the password..<br>");
		else if (!ValidationUtil.doPasswordsMatch(password, confirmPassword))
		return "Passwords do not match.";
		
		return errors.length() == 0 ? null : errors.toString();
	}

	/**
	 * Extracts the customer model from the registration form.
	 * 
	 * @param req the HttpServletRequest containing the form data
	 * @return a CustomerModel object populated with the registration data
	 * @throws Exception if passwords do not match or another error occurs during extraction
	 */
	private CustomerModel extractCustomerModel(HttpServletRequest req) throws Exception {
		String title = req.getParameter("title");
		String username = req.getParameter("username");
		String customerName = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phno = req.getParameter("phonenumber");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");

		if (password == null || !password.equals(confirmPassword)) {
			throw new Exception("Passwords do not match or are invalid.");
		}

		password = PasswordUtil.encrypt(username, password);

		return new CustomerModel(title, username, customerName, email, phno, dob, password);
	}

	/**
	 * Handles successful registration by forwarding to a success page.
	 * 
	 * @param req the HttpServletRequest
	 * @param resp the HttpServletResponse
	 * @param message the success message to display
	 * @param redirectPage the page to redirect to
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
			throws ServletException, IOException {
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
	}

	/**
	 * Handles errors by forwarding to the registration page with an error message.
	 * 
	 * @param req the HttpServletRequest
	 * @param resp the HttpServletResponse
	 * @param message the error message to display
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
			throws ServletException, IOException {
		req.setAttribute("error", message);
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}
}
