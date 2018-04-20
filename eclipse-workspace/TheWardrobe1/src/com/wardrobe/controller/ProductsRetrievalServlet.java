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

import com.wardrobe.dao.GetProductsDao;
import com.wardrobe.model.Products;

/**
 * Servlet implementation class ProductsRetrievalServlet
 */
@WebServlet("/ProductsRetrievalServlet")
public class ProductsRetrievalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Products> productsRetrievedList=new ArrayList<Products>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsRetrievalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
/*		 GetProductsDao dao=new GetProductsDao();
		 itemsList= dao.get3Products();
		 request.setAttribute("Items", itemsList);
		 System.out.println(itemsList);
		 request.getRequestDispatcher("index.jsp").forward(request, response);*/
		
		String catName = request.getParameter("value");
		
		GetProductsDao dao=new GetProductsDao();		
		productsRetrievedList=dao.getProductsByCategory(catName);
		
		
		List<String> size = productsRetrievedList.stream().map(Products::getSize).collect(Collectors.toList());
		List<String> color = productsRetrievedList.stream().map(Products::getColor).collect(Collectors.toList());
		Set<String> sizeValues = new HashSet<String>(size);
		Set<String> colorValues = new HashSet<String>(color);
	
		request.setAttribute("Category", catName);
		request.setAttribute("Size", sizeValues);
		request.setAttribute("Color", colorValues);
		request.setAttribute("Items", productsRetrievedList);
		
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
