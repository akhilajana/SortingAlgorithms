package com.wardrobe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wardrobe.dao.AuthenticationDao;
import com.wardrobe.dao.GetProductsDao;
import com.wardrobe.dao.ProductActionsDao;
import com.wardrobe.model.Products;
import com.wardrobe.model.User;

/**
 * Servlet implementation class ProductActionsServlet
 */
@WebServlet("/ProductActionsServlet")
public class ProductActionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductActionsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		String catName = request.getParameter("value");
//
//		request.setAttribute("Category", catName);
//		System.out.println(catName);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


		if (request.getParameter("insert_item")!=null) {
			// Adding product to database
			int status = 0;
			
			int itemId = Integer.parseInt(request.getParameter("prdId"));
			String itemName = request.getParameter("prdName");
			String itemDesc = request.getParameter("prdDesc");
			String itemSize = request.getParameter("size");
			Double itemPrice = Double.parseDouble(request.getParameter("price"));
			String itemColor = request.getParameter("color");
			String itemCategory = request.getParameter("cat");
			String imgUrl = request.getParameter("imgUrl");
			int itemQty = Integer.parseInt(request.getParameter("qty"));

			System.out.println(itemId);

			HttpSession session = request.getSession();
			Products item = new Products(itemId,itemQty,itemName,itemDesc,itemSize, itemPrice, itemColor,itemCategory,imgUrl);
			ProductActionsDao dao = new ProductActionsDao();
			status = dao.insert_item(item);

			System.out.println(status);

			if (status > 0) {
				//Item added to database
				request.getRequestDispatcher("admin_actions.jsp").forward(request, response);
			} else {
				//Item has not been added
			}
		} if (request.getParameter("delete_item")!=null) {
			// Remove product from database
			
			int status = 0;
			int itemId = Integer.parseInt(request.getParameter("prdId"));
			System.out.println(itemId);

			HttpSession session = request.getSession();
			ProductActionsDao dao = new ProductActionsDao();
			status = dao.delete_item(itemId);


			if (status > 0) {
				//Item deleted from database
				request.getRequestDispatcher("admin_actions.jsp").forward(request, response);
			} else {
				//Item has not been deleted
			}
		} 

	}

}
