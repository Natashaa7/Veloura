package com.veloura.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LMU ID: 23048637
 * NAME: NATASHA BABU
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/aboutus", 
		})
public class AboutUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor.
     */
    public AboutUsController() {
        super();
    }

	/**
	 * Handles GET requests for the About Us page.
	 * 
	 * @param request the HttpServletRequest object that contains the request the client made to the servlet
	 * @param response the HttpServletResponse object that contains the response the servlet returns to the client
	 * @throws ServletException if the request could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/aboutUs.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests by delegating to the doGet method.
	 * 
	 * @param request the HttpServletRequest object that contains the request the client made to the servlet
	 * @param response the HttpServletResponse object that contains the response the servlet returns to the client
	 * @throws ServletException if the request could not be handled
	 * @throws IOException if an input or output error is detected when the servlet handles the POST request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
