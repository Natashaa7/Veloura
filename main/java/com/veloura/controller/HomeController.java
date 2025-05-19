package com.veloura.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.veloura.util.RedirectionUtil;

/**
 * HomeController handles HTTP requests for the home and index routes of the application.
 *
 * This servlet maps to "/home" and "/index" and forwards the request to the homepage
 * as defined in {@link RedirectionUtil#homeUrl}.
 *
 * LMU ID: 23048637
 * NAME: Natasha Babu
 */
@WebServlet(
    asyncSupported = true,
    urlPatterns = {
        "/home",
        "/index"
    }
)
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     * Initializes the HomeController servlet.
     */
    public HomeController() {
        super();
    }

    /**
     * Handles GET requests and forwards them to the homepage.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(RedirectionUtil.homeUrl).forward(request, response);
    }

    /**
     * Handles POST requests by delegating to the doGet method.
     * Useful for uniform handling of both request types.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an input or output error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
