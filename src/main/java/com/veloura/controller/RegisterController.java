package com.veloura.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.veloura.util.PasswordUtil;
import com.veloura.model.CustomerModel;
import com.veloura.service.RegisterService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
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
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		this.service = new RegisterService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			CustomerModel customerModel = extractCustomerModel(req);
			System.out.println("Extracted Customers");
			Boolean isRegistered = service.registerCustomer(customerModel);
			System.out.println("User registered");
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

	

	private CustomerModel extractCustomerModel(HttpServletRequest req) throws Exception {
		System.out.println("Reacherd here 1");
		String title = req.getParameter("title");
		String username = req.getParameter("username");
		String customerName = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phno = req.getParameter("phonenumber");
		System.out.println("Reacherd here 2");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		System.out.println("Reacherd here 3");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		System.out.println(password);
		System.out.println(confirmPassword);
		if (password == null || !password.equals(confirmPassword)) {
			throw new Exception("Passwords do not match or are invalid.");
		}

		password = PasswordUtil.encrypt(username, password);

		return new CustomerModel(title, username, customerName, email, phno, dob, password);
	}

	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage) throws ServletException, IOException {
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
		// TODO Auto-generated method stub	
	}

	private void handleError(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
		req.setAttribute("error", message);
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
		// TODO Auto-generated method stub
		
	}
}
