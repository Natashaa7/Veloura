package com.veloura.util;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Natasha Babu
 * lmu id: 23048637
 */
public class RedirectionUtil {

	private static final String baseUrl = "/WEB-INF/pages/";
	public static final String registerUrl = baseUrl + "register.jsp";
	public static final String loginUrl = baseUrl + "login.jsp";
	public static final String homeUrl = baseUrl + "home.jsp";
	public static final String adminUrl = baseUrl + "adminDashboard.jsp";

	/**
	 * Sets a request attribute for displaying a message in the JSP.
	 */
	public void setMsgAttribute(HttpServletRequest req, String msgType, String msg) {
		req.setAttribute(msgType, msg);
	}

	/**
	 * Forwards the request to the specified JSP page.
	 */
	public void redirectToPage(HttpServletRequest req, HttpServletResponse resp, String page)
			throws ServletException, IOException {
		req.getRequestDispatcher(page).forward(req, resp);
	}

	/**
	 * Sets a message attribute and forwards to a JSP page.
	 */
	public void setMsgAndRedirect(HttpServletRequest req, HttpServletResponse resp, String msgType, String msg,
			String page) throws ServletException, IOException {
		setMsgAttribute(req, msgType, msg);
		redirectToPage(req, resp, page);
	}

}