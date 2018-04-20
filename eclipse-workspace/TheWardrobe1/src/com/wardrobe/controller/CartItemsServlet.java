package com.wardrobe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
       ArrayList<CartItem> cartItems=new ArrayList<CartItem>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out=response.getWriter();
//		HttpSession session=request.getSession(); 
//		User user=(User) session.getAttribute("user");
//		CartDao dao=new CartDao();
//		cartItems=dao.getCartItems(user.getId());
//		String cartList="";
//		for(int i=0;i<cartItems.size();i++)
//		{
//			CartItem itemC=cartItems.get(i);
//			String cItemContainer="<div class='col-md-12 col-xs-12 cartItem'><div class='cartImg col-md-4 col-xs-12'><img src='"+itemC.getItem_ImgUrl()+"'></div><div class='cartItemData col-md-8 col-xs-12'><div class='icName'>"+ itemC.getItemName()+"</div><div class='icPrice'>"+  itemC.getItemPrice()+"</div></div><div class='clear_fix'></div></div><div class='clear_fix'></div>";
//			cartList=cartList+cItemContainer;
//		}
//		out.print(cartList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(); 
		User user=(User) session.getAttribute("user");
		
		
		System.out.println("id"+request.getParameter("productId"));
	
		System.out.println("price"+request.getParameter("iPrice"));
		
	//Get product details from database	
		ProductDetailDao dao=new ProductDetailDao();
		int productId=Integer.parseInt(request.getParameter("productId"));
		Products item=dao.getProductById(productId);
		request.setAttribute("DetailItem", item);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	//Update cart in database	
			CartItem cartItem=new CartItem();
			cartItem.setItemid(Integer.parseInt(request.getParameter("productId")));
			cartItem.setItemName(item.getName());
			cartItem.setItemQty(1);
			cartItem.setUserId(user.getId());
			cartItem.setItemPrice(item.getPrice());
			cartItem.setItem_ImgUrl(item.getImageUrl());
			
			CartDao cartdao = new CartDao();
			int status=cartdao.insert_cart(cartItem);
			
			cartItems=cartdao.getCartItems(user.getId());
			
			String cartList="";
			for(int i=0;i<cartItems.size();i++){
				CartItem itemC=cartItems.get(i);
				String cItemContainer="<div class='col-md-12 col-xs-12 cartItem'><div class='cartImg col-md-4 col-xs-12'><img src='"+itemC.getItem_ImgUrl()+"'></div><div class='cartItemData col-md-8 col-xs-12'><div class='icName'>"+ itemC.getItemName()+"</div><div class='icPrice'>"+  itemC.getItemPrice()+"</div></div><div class='clear_fix'></div></div><div class='clear_fix'></div>";
				cartList=cartList+cItemContainer;
			}
			out.print(cartList);
		 }
	

}
