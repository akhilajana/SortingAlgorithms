package com.wardrobe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wardrobe.model.Products;
import com.wardrobe.model.User;

public class UserDao {
	
	private static ResultSet resultSet = null;
	  private static PreparedStatement pstatement=null;
	  public static String USER_TYPE="";
	   public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
//	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wardrobeModel","root","root");
	            con=DriverManager.getConnection("jdbc:mysql://awswardrobemodel.cjgqsqxh9apc.us-east-1.rds.amazonaws.com:3306/awsDB","awsroot1","awsroot1");

	        }
	            catch(Exception e){System.out.println(e);}  
		        return con;
	   }
	   public User getUserDetails(String userName) {
			// TODO Auto-generated method stub
			try{
				   Connection con=getConnection();
	        	   User user=new User();

				   PreparedStatement statement=(PreparedStatement) con.prepareStatement("SELECT * FROM user where UserName=?;");
				   statement.setString(1, userName);
		           resultSet=statement.executeQuery();
		           while(resultSet.next())
		           {
		        	   user.setId(resultSet.getInt("id"));
		        	   user.setName(resultSet.getString("name"));
	    				user.setPhone_no(resultSet.getString("Phone_no"));
	    				user.setUsername(resultSet.getString("username"));
	    				user.setPassword(resultSet.getString("password"));
	    				user.setType(resultSet.getString("type"));
	    				user.setEmail(resultSet.getString("Email"));
	    				user.setStatusMsg("success");
		    		   
		           }
		           return user;
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
			   return null;
		}

}
