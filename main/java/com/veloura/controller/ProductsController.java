package com.veloura.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.veloura.model.JewelleryModel;
import com.veloura.service.ProductsDashboardService;

/**
 * ProductsController handles requests to the "/products" endpoint.
 * It is responsible for forwarding users to the products page.
 * 
 * LMU ID: 23048637  
 * NAME: Natasha Babu
 */
@WebServlet(
    asyncSupported = true,
    urlPatterns = {
        "/products"
    }
)
public class ProductsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductsDashboardService service;
    /**
     * Default constructor for ProductsController.
     */
    public ProductsController() {
        super();
        this.service = new ProductsDashboardService();
    }

    /**
     * Handles GET requests to "/products".
     * Forwards the request to the products JSP page for rendering.
     *
     * @param request  the HttpServletRequest object containing the client's request
     * @param response the HttpServletResponse object for sending the response to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<JewelleryModel> products;
		products = service.getAllJewellery();
		request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/pages/products.jsp").forward(request, response);
    }

    /**
     * Handles POST requests to "/products".
     * Delegates the request to the doGet method for rendering the same view.
     *
     * @param req  the HttpServletRequest object containing the client's request
     * @param resp the HttpServletResponse object for sending the response to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
