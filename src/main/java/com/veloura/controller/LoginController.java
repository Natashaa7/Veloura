package com.veloura.controller;

import java.io.IOException;

import com.veloura.model.CustomerModel;
import com.veloura.service.LoginService;
import com.veloura.util.CookiesUtil;
import com.veloura.util.SessionUtil;
import com.veloura.util.RedirectionUtil;
import com.veloura.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Natasha Babu
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidationUtil validationUtil;
	private RedirectionUtil redirectionUtil;
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		this.validationUtil = new ValidationUtil();
		this.redirectionUtil = new RedirectionUtil();
		this.loginService = new LoginService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (!validationUtil.isNullOrEmpty(username) && !validationUtil.isNullOrEmpty(password)) {

			CustomerModel customerModel = new CustomerModel(username, password);
			Boolean loginStatus = loginService.loginUser(customerModel);

			if (loginStatus != null && loginStatus) {
				System.out.println("here2");
				SessionUtil.setAttribute(req, "username", username);
				System.out.println("here");
				if (username.equals("admin")) {
					System.out.println("here2");
					CookiesUtil.addCookie(resp, "role", "admin", 5 * 30);
					resp.sendRedirect(req.getContextPath() + "/admin"); // Redirect to /home
				} else {
					CookiesUtil.addCookie(resp, "role", "customer", 5 * 30);
					resp.sendRedirect(req.getContextPath() + "/home"); // Redirect to /home
				}
			} else {
				handleLoginFailure(req, resp, loginStatus);
			}
		} else {
			redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please fill all the fields!",
					RedirectionUtil.loginUrl);
		}
	}

	/**
	 * Handles login failures by setting attributes and forwarding to the login
	 * page.
	 *
	 * @param req         HttpServletRequest object
	 * @param resp        HttpServletResponse object
	 * @param loginStatus Boolean indicating the login status
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
			throws ServletException, IOException {
		String errorMessage;
		if (loginStatus == null) {
			errorMessage = "Our server is under maintenance. Please try again later!";
		} else {
			errorMessage = "User credential mismatch. Please try again!";
		}
		req.setAttribute("error", errorMessage);
		req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
	}

}