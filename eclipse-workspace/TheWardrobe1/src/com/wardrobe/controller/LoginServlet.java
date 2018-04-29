package com.wardrobe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wardrobe.dao.AuthenticationDao;
import com.wardrobe.dao.GetProductsDao;
import com.wardrobe.dao.LoginDao;
import com.wardrobe.model.Products;
import com.wardrobe.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Products> itemsList=new ArrayList<Products>();

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session=request.getSession();
		String username=request.getParameter("uname");
		 String password=request.getParameter("pass");
		 
		 //Decrypt password
		 PasswordUtil pwdUtil = new PasswordUtil();
	     String decryptedPassword=pwdUtil.decrypt(password);
	     System.out.println("Depwd"+decryptedPassword);
		 
		 AuthenticationDao auDao=new AuthenticationDao();
		 User user=auDao.login_Check(username,password);
		 if(user.getStatusMsg().equalsIgnoreCase("success")){
			   session.setAttribute("user", user);
			   GetProductsDao dao=new GetProductsDao();
//			   OrderDetailsDao dao1=new OrderDetailsDao();
				itemsList= dao.get3Products();
				request.setAttribute("Items", itemsList);
				System.out.println(itemsList);
			
				if(user.getType().equalsIgnoreCase("Admin")){
	//				ordersList=dao1.getOrders();
	//				unapprovedList=dao.getUnApprovedItems(false);
	//				request.setAttribute("Orders", ordersList);
//					request.setAttribute("UnapprovedList", unapprovedList);
					request.getRequestDispatcher("admin.jsp").forward(request, response);
					
				}
				else if(user.getType().equalsIgnoreCase("customer")){
					
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
		 }
		 else if(user.getStatusMsg().equalsIgnoreCase("failed")){
			   request.getRequestDispatcher("login.jsp").forward(request, response);
		 }
		
	}

}
