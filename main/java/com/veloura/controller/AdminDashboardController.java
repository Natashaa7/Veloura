package com.veloura.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.veloura.model.JewelleryModel;
import com.veloura.service.AdminDashboardService;
import com.veloura.util.RedirectionUtil;

/**
 * Controller class that handles HTTP requests for the admin dashboard.
 *
 * LMU ID: 23048637  
 * NAME: NATASHA BABU
 */
@WebServlet(
    asyncSupported = true, 
    urlPatterns = { 
        "/adminDashboard"
    })
public class AdminDashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDashboardService service;

    /**
     * Default constructor that initializes the AdminDashboardService.
     */
    public AdminDashboardController() {
        super();
        this.service = new AdminDashboardService();
    }

    /**
     * Handles GET requests for the admin dashboard page.
     * Retrieves dashboard metrics including total cost, customer count,
     * jewellery count, top 5 expensive jewellery, and recently added items.
     * Sets these as attributes and forwards to the admin view.
     * 
     * @param request the HttpServletRequest object that contains the request the client made to the servlet
     * @param response the HttpServletResponse object that contains the response the servlet returns to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an input or output error is detected when the servlet handles the GET request
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalJewelleryCost = service.getTotalJewelleryCost();
        int totalCustomers = service.getTotalCustomerCount();
        int totalJewellery = service.getTotalJewelleryCount();

        List<JewelleryModel> expensiveJewels = service.getTop5ExpensiveJewellery();
        List<JewelleryModel> recentlyAdded = service.getRecentlyAdded();

        request.setAttribute("expensiveJewels", expensiveJewels);
        request.setAttribute("recentlyAdded", recentlyAdded);

        request.setAttribute("totalJewelleryCost", totalJewelleryCost);
        request.setAttribute("totalCustomers", totalCustomers);
        request.setAttribute("totalJewellery", totalJewellery);

        request.getRequestDispatcher(RedirectionUtil.adminUrl).forward(request, response);
    }

    /**
     * Handles POST requests by delegating to the doGet method.
     * 
     * @param request the HttpServletRequest object that contains the request the client made to the servlet
     * @param response the HttpServletResponse object that contains the response the servlet returns to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an input or output error is detected when the servlet handles the POST request
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
