package com.veloura.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import com.veloura.model.JewelleryModel;
import com.veloura.service.ProductsDashboardService;
import com.veloura.util.ImageUtil;
import com.veloura.util.ValidationUtil;

/**
 * Servlet controller for managing jewellery products.
 * Handles displaying, adding, updating, and deleting products via /productsDashboard endpoint.
 * 
 * LMU ID: 23048637
 * NAME: Natasha Babu
 */
@WebServlet(
	asyncSupported = true, 
	urlPatterns = { "/productsDashboard" }
)
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	maxFileSize = 1024 * 1024 * 10,      // 10MB
	maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class ProductsDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ImageUtil imageUtil = new ImageUtil();
	private ProductsDashboardService service;

	/**
	 * Default constructor that initializes the service.
	 */
	public ProductsDashboardController() {
		super();
		this.service = new ProductsDashboardService();
	}

	/**
	 * Handles GET requests by retrieving all jewellery items and forwarding to the JSP view.
	 * ASDFGHJKASDFGHJK
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery = request.getParameter("search");
		List<JewelleryModel> products;
		
		if (searchQuery != null && !searchQuery.trim().isEmpty()) {
		    // Search for products by jewellery name
			products = service.searchJewelleryByName(searchQuery.trim());
			request.setAttribute("editable", true);
		} else {
		    // Get all jewellery details if no search query is performed
		    products = service.getAllJewellery();
		    request.setAttribute("editable", false);
		}
		request.setAttribute("products", products);
		request.getRequestDispatcher("WEB-INF/pages/productsDashboard.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests for actions like add, update, and delete.
	 * ASDFGHJKHGFSSDFGHJ
	 * @param req  the HttpServletRequest object
	 * @param resp the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		try {
			// DELETE ACTION
			if ("delete".equals(action)) {
				int deleteId = Integer.parseInt(req.getParameter("delete_id"));
				boolean success = service.deleteJewelleryById(deleteId);
				if (success) {
	                req.setAttribute("success", "Product deleted successfully.");
	            } else {
	                req.setAttribute("error", "Failed to delete product.");
	            }
				List<JewelleryModel> products = service.getAllJewellery();
				req.setAttribute("products", products);
				req.getRequestDispatcher("/WEB-INF/pages/productsDashboard.jsp").forward(req, resp);
				return;
			}

			if ("update".equals(action)) {
			    int jewelleryId = Integer.parseInt(req.getParameter("update_id"));
			    
			    String name = req.getParameter("name");
			    System.out.println("jewels" + name);
			    String material = req.getParameter("material");
			    int gold = Integer.parseInt(req.getParameter("gold"));
			    int stock = Integer.parseInt(req.getParameter("stock"));
			    int cost = Integer.parseInt(req.getParameter("cost"));
			    String diamondStr = req.getParameter("diamond");
			    if (diamondStr == null || diamondStr.isBlank()) {
			        throw new IllegalArgumentException("Diamond value is required");
			    }
			    double diamond = Double.parseDouble(diamondStr);
			    
			    JewelleryModel updatedModel = new JewelleryModel(jewelleryId, name, material, diamond, gold, stock, cost);
			    
			    boolean updated = service.updateJewellery(updatedModel);
			    
			    if (updated) {
			        handleSuccess(req, resp, "Product updated successfully!", "/WEB-INF/pages/productsDashboard.jsp");
			    } else {
			        handleError(req, resp, "Update failed.");
			    }
			    return;
			}

			// ADD PRODUCT ACTION
			String validationMessage = validateJewelleryForm(req);
			if (validationMessage != null) {
				handleError(req, resp, validationMessage);
				return;
			}
			
			JewelleryModel jewelleryModel = extractJewelleryModel(req);
			Boolean isAdded = service.addJewellery(jewelleryModel);

			if (isAdded == null) {
				handleError(req, resp, "Server issue. Try again later.");
			} else if (isAdded) {
				handleSuccess(req, resp, "Product added successfully!", "/WEB-INF/pages/productsDashboard.jsp");
			} else {
				handleError(req, resp, "Could not add the product.");
			}
		} catch (Exception e) {
			handleError(req, resp, "An unexpected error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * Validates the form inputs submitted by the user.
	 * 
	 * @param req the HttpServletRequest object
	 * @return a validation error message if inputs are invalid, or null if valid
	 */
	private String validateJewelleryForm(HttpServletRequest req) {
		StringBuilder errors = new StringBuilder();

		String jewellery = req.getParameter("jewellery_name");
		String material = req.getParameter("material");
		String diamond = req.getParameter("diamonds");
		String gold = req.getParameter("gold");
		String stock = req.getParameter("stock");
		String cost = req.getParameter("total_cost");

		if (ValidationUtil.isNullOrEmpty(jewellery))
			errors.append("Jewellery name is required.<br>");
		else if (!ValidationUtil.isValidJewelleryName(jewellery))
			errors.append("Jewellery name must start with a letter and contain only letters.<br>");

		if (ValidationUtil.isNullOrEmpty(material))
			errors.append("Material is required.<br>");
		else if (!ValidationUtil.isValidMaterial(material))
			errors.append("Material should be yellow gold, white gold, rose gold, platinum, or silver.<br>");

		if (ValidationUtil.isNullOrEmpty(diamond))
			errors.append("Diamond is required.<br>");
		else if (!ValidationUtil.isValidDiamond(diamond))
			errors.append("Invalid diamond carat.<br>");

		if (ValidationUtil.isNullOrEmpty(gold))
			errors.append("Gold carat is required.<br>");
		else if (!ValidationUtil.isValidGold(gold))
			errors.append("Gold should be either 0/18/22/24.<br>");

		if (ValidationUtil.isNullOrEmpty(stock))
			errors.append("Stock is required.<br>");
		else if (!ValidationUtil.isValidStock(stock))
			errors.append("Stock exceeds limit.<br>");

		if (ValidationUtil.isNullOrEmpty(cost))
			errors.append("Cost is required.<br>");
		else if (!ValidationUtil.isValidTotalCost(cost))
			errors.append("Total cost exceeds limit.<br>");
		
		
		
		return errors.length() == 0 ? null : errors.toString();
	}

	/**
	 * Extracts and constructs a JewelleryModel from the HTTP request parameters.
	 * 
	 * @param req the HttpServletRequest object
	 * @return the constructed JewelleryModel
	 * @throws Exception if parameter parsing fails
	 */
	private JewelleryModel extractJewelleryModel(HttpServletRequest req) throws Exception {
		String jewellery = req.getParameter("jewellery_name");
		String material = req.getParameter("material");
		double diamond = Double.parseDouble(req.getParameter("diamonds"));
		int gold = Integer.parseInt(req.getParameter("gold"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		int cost = Integer.parseInt(req.getParameter("total_cost"));
		Part filePart = req.getPart("image");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		String uploadPath = req.getServletContext().getRealPath("/");

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdirs();

		filePart.write(uploadPath + File.separator + fileName);

		// Save fileName in the DB, not the whole path
		String image = "resources/images/system/" + fileName;
		
		return new JewelleryModel(jewellery, material, diamond, gold, stock, cost, image);
	}
	
	/**
	 * Handles the image upload from the multipart form data.
	 *
	 * @param req the HttpServletRequest containing the image file part
	 * @return true if the image is uploaded successfully; false otherwise
	 * @throws IOException if an I/O error occurs during upload
	 * @throws ServletException if the request does not contain multipart content
	 */
	private boolean uploadImage(HttpServletRequest req) throws IOException, ServletException {
		Part filePart = req.getPart("image");
		return imageUtil.uploadImage(filePart, req.getServletContext().getRealPath("/"), "system");
	}

	/**
	 * Forwards the request with a success message and refreshed product list.
	 * 
	 * @param req          the HttpServletRequest object
	 * @param resp         the HttpServletResponse object
	 * @param message      the success message to show
	 * @param redirectPage the JSP page to forward to
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage) throws ServletException, IOException {
		req.setAttribute("success", message);
		List<JewelleryModel> products = service.getAllJewellery();
		req.setAttribute("products", products);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
	}

	/**
	 * Forwards the request with an error message and refreshed product list.
	 * 
	 * @param req     the HttpServletRequest object
	 * @param resp    the HttpServletResponse object
	 * @param message the error message to show
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleError(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
		req.setAttribute("error", message);
		List<JewelleryModel> products = service.getAllJewellery();
		req.setAttribute("products", products);
		req.getRequestDispatcher("/WEB-INF/pages/productsDashboard.jsp").forward(req, resp);
	}
}
