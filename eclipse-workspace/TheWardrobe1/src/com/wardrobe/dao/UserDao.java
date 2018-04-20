package com.wardrobe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
	private static ResultSet resultSet = null;
	  private static PreparedStatement pstatement=null;
	   public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wardrobeModel","root","root");
	        }
	            catch(Exception e){System.out.println(e);}  
		        return con;
	   }
	   public int user_update(int id,String connection)
	   {
		   int status=0;
		   try{
			   
		   Connection con=getConnection();
           PreparedStatement pstatement=(PreparedStatement) con.prepareStatement("insert into user values(?,?,?)");
      	   pstatement.setInt(1,id);//retrieved from session
      	   pstatement.setString(2,connection);//connection
      	  // pstatement.setBoolean(3,newsletter);
      	   
      	   status=pstatement.executeUpdate();
       
         //con.close(); 
		   }
		   catch(Exception ex){
			   ex.printStackTrace();
		   }
		   return status;
	   }

}
