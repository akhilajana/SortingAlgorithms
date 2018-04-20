package com.wardrobe.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wardrobe.model.User;
public class AuthenticationDao 
{
	  private static ResultSet resultSet = null;
	  private static PreparedStatement pstatement=null;
	  public static String USER_TYPE="";
	   public static Connection getConnection()
	   {  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wardrobeModel","root","root");
	            	        }
	            catch(Exception e){System.out.println(e);}  
		        return con;
	   }
	   
	   public int signup_check(User user)
	   {
		   int status=0;
		   try{
		   
		   Connection con=getConnection();
		   PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert "
		   		+ "into user(name,phone_no,username,password,type,email) values (?,?,?,?,?,?)");
		   ps.setString(1,user.getName());
		   ps.setString(2,user.getPhone_no());
		   ps.setString(3,user.getUsername());
		   ps.setString(4,user.getPassword());
		   ps.setString(5,user.getType());
		   ps.setString(6,user.getEmail());
		   
           status=ps.executeUpdate();
           
           if(status>0)
           {
        	   user.setStatusMsg("Registered succesfully!");
		   }
           else
           {
        	   user.setStatusMsg("Registration unsuccessful");
           }
		   }
		   catch(Exception e)
		   {System.out.println(e);}
		   return status;
	   }
	   public User login_Check(String userName,String password)
	   {
		   User user=new User();
		   try{
		   		Connection con=getConnection();
	             pstatement=(PreparedStatement) con.prepareStatement("select * "
	            		+ "from user where username=? and password=?");
	             pstatement.setString(1,userName);
	             pstatement.setString(2,password);
	             resultSet=pstatement.executeQuery();
	             
	            while(resultSet.next())
	    		{
	    			if(userName.equals(resultSet.getString("username"))&&password.equals(resultSet.getString("password")))
	    			{
	    				USER_TYPE=resultSet.getString("type");
	    				user.setId(resultSet.getInt("id"));
	    				user.setName(resultSet.getString("name"));
	    				user.setUsername(resultSet.getString("username"));
	    				user.setPassword(resultSet.getString("password"));
	    				user.setType(resultSet.getString("type"));
	    				user.setStatusMsg("success");
	    				System.out.println("Login Successful..!!");
	    				return user;
	    				
	    			}
	    			else
	    			{
	    				if(!resultSet.next())
	    			    {System.out.println("Login Failed..!!");}
	    				else
	    				{continue;}
	    				user.setStatusMsg("Failed");
	    			}
	    		}
		   }
		   catch(Exception e)
		   {System.out.println(e);}
		   
		return user;
	            
	   }
	        
}


