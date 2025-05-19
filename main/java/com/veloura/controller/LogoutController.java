package com.veloura.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.veloura.util.CookiesUtil;
import com.veloura.util.SessionUtil;

/**
 * LogoutController handles user logout functionality.
 * It deletes the user's role cookie, invalidates the session,
 * and redirects to the login page.
 * 
 * LMU ID: 23048637  
 * NAME: Natasha Babu
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests to log out the user.
     * Clears session data and role cookies, then redirects to login.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delete role cookie
        CookiesUtil.deleteCookie(response, "role");
        
        // Invalidate user session
        SessionUtil.invalidateSession(request);
        
        // Redirect to login page
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
