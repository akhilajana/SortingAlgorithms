package com.wardrobe.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.wardrobe.model.Products;


public class ProductDetailDao 
{
	private static ResultSet resultSet = null;
	  
	  public static String USER_TYPE="";
	   public static Connection getConnection()
	   {  
	        Connection con=null;  
	        try
	        {  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wardrobeModel","root","root");
	            
	        }
	            catch(Exception e){System.out.println(e);}  
		        return con;
	   }
	   
	   public Products getProductById(int productId)
	   { 
		   try{
			   
			   Connection con=getConnection();
			   Products item=new Products();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from products where product_id=?");
	           statement.setInt(1,productId);
	           resultSet=statement.executeQuery();
	           
	           while(resultSet.next())
	           { 
	        	   item.setProductId(resultSet.getInt("product_id"));
	        	   item.setName(resultSet.getString("product_name"));
	        	   item.setDesc(resultSet.getString("product_descrption"));
	        	   item.setSize(resultSet.getString("product_size"));
	        	   item.setPrice(resultSet.getDouble("product_price"));
	        	   item.setColor(resultSet.getString("product_color"));
	    		   item.setCategory(resultSet.getString("product_category"));
	    		   item.setImageUrl(resultSet.getString("imageUrl"));
	    		   item.setQty(resultSet.getInt("product_qty"));
	    		      		  
	           }
	           return item;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }
	   
}
