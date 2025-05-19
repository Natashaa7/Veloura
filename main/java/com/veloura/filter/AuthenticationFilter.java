package com.veloura.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.veloura.util.CookiesUtil;
import com.veloura.util.SessionUtil;

/**
 * 
 * LMU ID: 23048637
 * NAME: NATASHA BABU
 * 
 * AuthenticationFilter is responsible for restricting access to specific URLs
 * based on the user's authentication status and role (admin or customer).
 * It redirects users to appropriate pages if they attempt to access unauthorized resources.
 * 
 * This filter applies to all URL patterns.
 */
@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private static final String LOGIN = "/login";
	private static final String REGISTER = "/signup";
	private static final String HOME = "/home";
	private static final String ROOT = "/";
	private static final String PRODUCTS = "/products";
	private static final String ADMIN_DASHBOARD = "/adminDashboard";
	private static final String PRODUCTS_DASHBOARD = "/productsDashboard";
	private static final String CUSTOMER_PROFILE = "/cprofile";
	private static final String ADMIN_PROFILE = "/aprofile";
	private static final String ABOUT = "/aboutus";
	private static final String CONTACT = "/contactus";
	private static final String LOGOUT = "/logout";

	/**
	 * Initializes the filter.
	 * 
	 * @param filterConfig the configuration object provided by the container
	 * @throws ServletException if an error occurs during initialization
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic, if required
	}

	/**
	 * Filters incoming requests and redirects users based on login status and role.
	 *
	 * @param request  the ServletRequest object, should be cast to HttpServletRequest
	 * @param response the ServletResponse object, should be cast to HttpServletResponse
	 * @param chain    the FilterChain to pass control to the next filter or servlet
	 * @throws IOException      if an input or output error occurs while handling the request
	 * @throws ServletException if the processing fails for servlet reasons
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();

		// Allow access to static resources
		if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css")) {
			chain.doFilter(request, response);
			return;
		}

		boolean isLoggedIn = SessionUtil.getAttribute(req, "username") != null;
		String userRole = CookiesUtil.getCookie(req, "role") != null ? CookiesUtil.getCookie(req, "role").getValue()
				: null;

		if (isLoggedIn) {
			if ("admin".equals(userRole)) {
				// Admin is logged in
				if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
					res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
				} else if (uri.endsWith(ADMIN_DASHBOARD) || uri.endsWith(PRODUCTS_DASHBOARD)
						|| uri.endsWith(ADMIN_PROFILE) || uri.endsWith(ABOUT) || uri.endsWith(CONTACT)
						|| uri.endsWith(LOGOUT) || uri.endsWith(ROOT)) {
					chain.doFilter(request, response);
				} else {
					res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
				}
			} else if ("customer".equals(userRole)) {
				// Customer is logged in
				if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
					res.sendRedirect(req.getContextPath() + HOME);
				} else if (uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT) || uri.endsWith(PRODUCTS)
						|| uri.endsWith(CONTACT) || uri.endsWith(CUSTOMER_PROFILE) || uri.endsWith(LOGOUT)) {
					chain.doFilter(request, response);
				} else {
					res.sendRedirect(req.getContextPath() + HOME);
				}
			}
		} else {
			// Not logged in
			if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(HOME) || uri.endsWith(ROOT)) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + LOGIN);
			}
		}
	}

	/**
	 * Cleans up any resources used by the filter.
	 */
	/*@Override
	public void destroy() {
		// Cleanup logic, if required
	}*/
}
