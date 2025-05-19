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
				"/contactus", 
		})
public class ContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor.
     */
    public ContactUsController() {
        super();
    }

	/**
	 * Handles GET requests for the contact us page.
	 * 
	 * @param request the HttpServletRequest object that contains the request the client made to the servlet
	 * @param response the HttpServletResponse object that contains the response the servlet returns to the client
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an input or output error is detected when the servlet handles the GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/contactUs.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests for submitting the contact form.
	 * 
	 * @param request the HttpServletRequest object that contains the request the client made to the servlet
	 * @param response the HttpServletResponse object that contains the response the servlet returns to the client
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an input or output error is detected when the servlet handles the POST request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieving form data
        String fullName = request.getParameter("username");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        String message = request.getParameter("message");

        // Setting a message for the user and forwarding to the contact us page
        request.setAttribute("message", "Message Sent!");
        request.getRequestDispatcher("/WEB-INF/pages/contactus.jsp").forward(request, response);
	}
}
