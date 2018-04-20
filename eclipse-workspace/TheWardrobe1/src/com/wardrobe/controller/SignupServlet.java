package com.wardrobe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wardrobe.dao.AuthenticationDao;
import com.wardrobe.model.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int status=0;
		 String fName=request.getParameter("fullName");  
	     String userName=request.getParameter("userName");
	     String email=request.getParameter("emailId");
	     String phoneNo=request.getParameter("phoneNo");
	     String password=request.getParameter("pwd");
	     
	     System.out.println(fName);
	     
	     HttpSession session=request.getSession();
	     User user=new User(fName,userName,password,"customer",email,phoneNo);
	     AuthenticationDao dao=new AuthenticationDao();
	     status=dao.signup_check(user);
	     
	     System.out.println(status);
	 
	     
	     if(status>0){
	    	 User signeduser=dao.login_Check(user.getUsername(), user.getPassword());
	    	 session.setAttribute("user",signeduser);
	    	 request.getRequestDispatcher("index.jsp").forward(request, response);
	     }
	     else{
	    	 request.getRequestDispatcher("signup.jsp").forward(request, response);
	     }
	}

}
