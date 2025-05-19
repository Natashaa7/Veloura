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
 * LoginController manages the login process for users.
 * It handles both displaying the login page and processing login credentials.
 * 
 * If the login is successful:
 * - Admin users are redirected to the admin dashboard.
 * - Regular users are redirected to the homepage.
 * 
 * LMU ID: 23048637  
 * NAME: Natasha Babu
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ValidationUtil validationUtil;
    private RedirectionUtil redirectionUtil;
    private LoginService loginService;

    /**
     * Initializes the controller and its dependencies.
     */
    @Override
    public void init() throws ServletException {
        this.validationUtil = new ValidationUtil();
        this.redirectionUtil = new RedirectionUtil();
        this.loginService = new LoginService();
    }

    /**
     * Handles GET requests by displaying the login page.
     *
     * @param req  the HttpServletRequest
     * @param resp the HttpServletResponse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
    }

    /**
     * Handles POST requests for login submission.
     * Performs validation and authentication, sets session and cookie attributes.
     *
     * @param req  the HttpServletRequest
     * @param resp the HttpServletResponse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an input or output error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!validationUtil.isNullOrEmpty(username) && !validationUtil.isNullOrEmpty(password)) {
            CustomerModel customerModel = new CustomerModel(username, password);
            Boolean loginStatus = loginService.loginUser(customerModel);

            if (Boolean.TRUE.equals(loginStatus)) {
                SessionUtil.setAttribute(req, "username", username);

                if ("admin".equals(username)) {	
                    CookiesUtil.addCookie(resp, "role", "admin", 5 * 30);
                    resp.sendRedirect(req.getContextPath() + "/adminDashboard?login=success");
                } else {
                    CookiesUtil.addCookie(resp, "role", "customer", 5 * 30);
                    resp.sendRedirect(req.getContextPath() + "/home?login=success");
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
     * Handles login failures by setting an appropriate error message
     * and forwarding the user back to the login page.
     *
     * @param req         the HttpServletRequest
     * @param resp        the HttpServletResponse
     * @param loginStatus the login result (true, false, or null)
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an input or output error occurs
     */
    private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
            throws ServletException, IOException {
        String errorMessage = (loginStatus == null)
                ? "Our server is under maintenance. Please try again later!"
                : "Invalid username or password";
        req.setAttribute("error", errorMessage); // Set error message in request scope
        req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp); // Forward
        
    }
}
