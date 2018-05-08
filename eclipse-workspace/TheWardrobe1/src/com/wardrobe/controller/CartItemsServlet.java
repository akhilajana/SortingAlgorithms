package com.wardrobe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wardrobe.dao.AuthenticationDao;
import com.wardrobe.dao.CartDao;
import com.wardrobe.dao.ProductDetailDao;
import com.wardrobe.model.CartItem;
import com.wardrobe.model.Products;
import com.wardrobe.model.User;

/**
 * Servlet implementation class CartItemsServlet
 */
@WebServlet("/CartItemsServlet")
public class CartItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartItemsServlet() {
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

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		CartDao dao = new CartDao();
		cartItems = dao.getCartItems(user.getId());
		request.setAttribute("CartItems", cartItems);
		request.getRequestDispatcher("cart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");


		// Get selected product details from database
		ProductDetailDao dao = new ProductDetailDao();
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("itemQty"));
		request.setAttribute("ItemQty", quantity);

		Products item = dao.getProductById(productId);
		request.setAttribute("DetailItem", item);
		// request.getRequestDispatcher("cart.jsp").forward(request, response);
		
		CartItem cartItem = new CartItem();
		cartItem.setItemid(productId);
		cartItem.setItemName(item.getName());
		cartItem.setItemQty(quantity); // get quantity from selected item
		cartItem.setUserId(user.getId());
		cartItem.setItemPrice(item.getPrice());
		cartItem.setItem_ImgUrl(item.getImageUrl());

		// check if item is already present in cart
		CartDao cartdao = new CartDao();
		//cartItems = cartdao.getCartItems(user.getId());

		if (!cartItems.isEmpty()) {
			List<Integer> itemIdsList = cartItems.stream().map(CartItem::getItemid).collect(Collectors.toList());

			for (Integer itemId : itemIdsList) {

				if (itemId == productId) {
					// update quantity in cart
					cartdao.update_cart(itemId);
					cartItems = cartdao.getCartItems(user.getId());
					break;
				} else {
					// add item to cart
					int status = cartdao.insert_cart(cartItem);

					cartItems = cartdao.getCartItems(user.getId());
					break;
				}
			}
		}		
System.out.println("Cart"+cartItems.toString());
			request.setAttribute("CartItems", cartItems);
			request.getRequestDispatcher("cart.jsp").forward(request, response);

		
	}

	

}
